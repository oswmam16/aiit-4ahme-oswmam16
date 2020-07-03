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
public class ConnectionWorker extends SwingWorker<Object, Response> {

    private boolean tryToStart;
    private boolean tryToStop;
    private boolean tryToClear;
    private boolean tryToEnd;

    private boolean cancel;

    private int sliderState = 0;

    private final Socket socket;

    public ConnectionWorker(int port, String host) throws IOException {
        socket = new Socket(host, port);
    }

    public void setTryToStart(boolean tryToStart) {
        this.tryToStart = tryToStart;
    }

    public void setTryToStop(boolean tryToStop) {
        this.tryToStop = tryToStop;
    }

    public void setTryToClear(boolean tryToClear) {
        this.tryToClear = tryToClear;
    }

    public void setTryToEnd(boolean tryToEnd) {
        this.tryToEnd = tryToEnd;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    protected Object doInBackground() throws Exception {
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        while (true) {
            try {
                final Server s = new Server();
                final Request req = s.new Request();
                final String reqString = g.toJson(req);
                writer.write(reqString + "\n");
                writer.flush();

                final String respString = reader.readLine();
                final Response resp = g.fromJson(respString, Response.class);
                publish(resp);

                synchronized (req) {
                    int localSliderState = sliderState;
                    Thread.sleep(1000 - localSliderState);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
