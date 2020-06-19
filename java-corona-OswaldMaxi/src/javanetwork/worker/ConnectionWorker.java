/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork.worker;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javanetwork.Server;
import javanetwork.Server.Request;
import javanetwork.Server.Response;
import javax.swing.SwingWorker;

/**
 *
 * @author maxio
 */
public class ConnectionWorker extends SwingWorker<String, Response> {

    private final Socket socket;

    public ConnectionWorker(int port, String host) throws IOException {
        socket = new Socket(host, port);
    }

    @Override
    protected String doInBackground() throws Exception {
        
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        while(true) {
            try {
                final Server s = new Server();
                final Request req = s.new Request();
                final String reqString = g.toJson(req);
                writer.write(reqString);
                writer.flush();
                
                final String respString = reader.readLine();
                final Response resp = g.fromJson(respString, Response.class);
                publish(resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
