/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maxio
 */



public class Server {
    
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    
    private long timeOffset;
    private long startMillis;
        
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        
        while(handlers.size() <= 3) {
            final Socket clientSocket = serverSocket.accept();
            new Thread(new ConnectionHandler(clientSocket) {
                @Override
                public void run() {
                    ConnectionHandler cH = new Server.ConnectionHandler(clientSocket);
                    handlers.add(cH);
                    if(cH.isMaster()) {
                        cH.run();
                    }
                }
            }).start();
        }        
    }
    
    public boolean isTimerRunning() {
        if(startMillis != 0) {
            return true;
        } 
        return false;
    }
    
    public long getTimerMillis() {
        return startMillis;
    }
    
    public void main(String[] args) throws IOException {
        
        timeOffset = 0;
        startMillis = System.currentTimeMillis();
        start(8080);
        
        if(startMillis == 0) {
            timeOffset = getTimerMillis();
            startMillis = 0;
        } else {
            timeOffset += System.currentTimeMillis() - startMillis;
        }
    }

    class ConnectionHandler implements Runnable{
    
        private Socket socket;
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
            
        }
    }
    
}

