/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxio
 */



public class Server {
    
    private ServerSocket serversocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    
    private long timeOffset;
    private long startMillis;
        
     public void start(int port) throws IOException {        
        serversocket = new ServerSocket(port);
        
        while(true) {
        
            final Socket socket = serversocket.accept();
            if(handlers.size() == 3) {
                // TODO überprüfen ob noch alle aktiv sind
                socket.close();
                continue;
            }
            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            handlers.add(handler);
        }
    }
    
    public boolean isTimerRunning() {
        return startMillis > 0;
    }
    
    public long getTimerMillis() {
        if(startMillis > 0) {
            return timeOffset + (System.currentTimeMillis() - startMillis);
        } else {
            return timeOffset;
        }
    }
    
    public void main(String[] args) throws IOException {
        new Server().start(8080);
    }
    

    class ConnectionHandler implements Runnable{
    
        private final Socket socket;
        private boolean master;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return socket.isClosed();
        }

        public boolean isMaster() {
            return master;
        }

        @Override
        public void run() {
            
            int count = 0;
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            
            while(true) {    
                try{
                    
                    final String req = reader.readLine();
                    count++;
                    final Gson gson = new Gson();
                    final Request r = gson.fromJson(req, Request.class);

                    if(r.isMaster()) {
                    } else {
                        boolean setMasterTrue = true;
                        for(ConnectionHandler h : handlers) {
                            if(!h.equals(this) && h.isMaster() == true) {
                                setMasterTrue = false;
                                break;
                            }
                        }
                        master = setMasterTrue;
                    }

                    if(r.isMaster()) {
                        if(r.isStart()) {
                            startMillis = System.currentTimeMillis();
                        }

                        if(r.isStop()) {
                            startMillis = -1;
                        } else {
                            timeOffset = System.currentTimeMillis() - startMillis + timeOffset;
                        }

                        if(r.isClear()) {
                            timeOffset = 0;
                            if(isTimerRunning()) {
                                startMillis = System.currentTimeMillis();
                            } else {
                                startMillis = 0;
                            }
                        }

                        if(r.isEnd()) {
                            serversocket.close();
                            socket.close();

                            handlers.remove(this);
                            return;
                        }        
                    }

                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    
}

