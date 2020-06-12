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
public class ConnectionWorker extends SwingWorker<Object, Response> {

    private final Socket socket;
    private javanetwork.gui.ClientGUI gui;

    public ConnectionWorker(int port, javanetwork.gui.ClientGUI gui) throws IOException {
        this.socket = new Socket("127.0.0.1", port);
        this.gui = gui;
    }

    @Override
    protected Object doInBackground() throws Exception {
        while(true) {
            Response resp = null;
            publish(resp);
        }
//        try {
//            final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
//            final Gson gson = new Gson();
//            Server s1 = new Server();
//            final Server.Request req = s1.new Request();
//            
//            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            final String resp = reader.readLine();
//            final Server.Response r = gson.fromJson(resp, Server.Response.class);
//            
//            if(!r.isMaster()) {
//                req.setMaster(true);
//            }
//            
//            final String reqString = gson.toJson(req, Server.Request.class);
//            writer.write(reqString);
//            writer.flush();
//            
//        } catch(Exception ex) {
//            
//        }
//        return 0;
    }

    @Override
    protected void process(List<Response> list) {
        for(Response r : list) {
            gui.handleResponse(r);
        }
    }

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
