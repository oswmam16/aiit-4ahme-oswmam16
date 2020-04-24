/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaNetwork;

import com.google.gson.Gson;
import java.io.BufferedReader;
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
        serverSocket = new ServerSocket(8080);
        timeOffset = 0;
        startMillis = System.currentTimeMillis();
        
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
            BufferedReader bfreader = new BufferedReader();

            String line = null;
            try {

            } catch(Exception ex) {
                throw new IllegalArgumentException();
            }

            Gson gson = new Gson();
            gson.toJson(line);
        }
    }
    
}
