/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaNetwork;

import java.io.IOException;
import java.net.ServerSocket;
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
        } else 
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
}
