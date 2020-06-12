/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javanetwork.Server.Response;
import javax.swing.SwingWorker;

/**
 *
 * @author maxio
 */
public class ConnectionWorker extends SwingWorker<String, Integer> {

    private final Socket socket;

    public ConnectionWorker(int port, String host) throws IOException {
        socket = new Socket(host, port);
    }

    @Override
    protected String doInBackground() throws Exception{
         System.out.println("Do in Background" + Thread.currentThread().getId());
         Thread.sleep(1000);
         
         publish(1);
       
         Thread.sleep(1000);
         
         publish(2);
         
         Thread.sleep(1000);
        return "OK";

    }
    
}
