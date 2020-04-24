/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaNetwork;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author maxio
 */
//class ConnectionHandler implements Runnable{
//    
//    private Socket socket;
//    private boolean master;
//
//    public ConnectionHandler(Socket socket) {
//        this.socket = socket;
//    }
//
//    public boolean isClosed() {
//        return socket.isClosed();
//    }
//    
//    public boolean isMaster() {
//        return master;
//    }
//    
//    @Override
//    public void run() {
//        BufferedReader bfreader = new BufferedReader();
//        
//        String line = null;
//        try {
//            
//        } catch(Exception ex) {
//            throw new IllegalArgumentException();
//        }
//        
//        Gson gson = new Gson();
//        gson.toJson(line);
//    }
//    
//}
