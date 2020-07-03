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

        while (true) {

            final Socket socket = serversocket.accept();
            synchronized (handlers) {
                for (ConnectionHandler h : handlers) {
                    if (h.isClosed()) {
                        handlers.remove(h);
                    }
                }
                if (handlers.size() == 3) {
                    socket.close();
                    continue;
                }
            }

            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            handlers.add(handler);
        }
    }

    public boolean isTimerRunning() {
        synchronized (handlers) {
            return startMillis > 0;
        }
    }

    public long getTimerMillis() {
        synchronized (handlers) {
            if (startMillis > 0) {
                return timeOffset + (System.currentTimeMillis() - startMillis);
            } else {
                return timeOffset;
            }
        }
    }

    //-----------------MAIN-----------------------------------------------------
    public static void main(String[] args) throws IOException {
        new Server().start(8080);
    }

    //----CONNECTION-HANDLER----------------------------------------------------
    private class ConnectionHandler implements Runnable {

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

            long count = 0;

            try {
                while (true) {

                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    final String req = reader.readLine();

                    if (req == null) {
                        socket.close();
                        return;
                    }

                    count++;
                    final Gson gson = new Gson();
                    final Request r = gson.fromJson(req, Request.class);

                    if (r.isMaster()) {
                        boolean setMasterTrue = true;
                        synchronized (handlers) {
                            for (ConnectionHandler h : handlers) {
                                if (!h.equals(this) && h.isMaster() == true) {
                                    setMasterTrue = false;
                                    break;
                                }
                            }
                            master = setMasterTrue;
                        }
                    }

                    synchronized (handlers) {
                        if (r.isMaster()) {
                            if (r.isStart()) {
                                startMillis = System.currentTimeMillis();
                            }

                            if (r.isStop()) {
                                startMillis = -1;
                            } else {
                                timeOffset = System.currentTimeMillis() - startMillis + timeOffset;
                            }

                            if (r.isClear()) {
                                timeOffset = 0;
                                if (isTimerRunning()) {
                                    startMillis = System.currentTimeMillis();
                                } else {
                                    startMillis = 0;
                                }
                            }

                            if (r.isEnd()) {
                                serversocket.close();
                                socket.close();
                                synchronized (socket) {
                                    handlers.remove(this);
                                    return;
                                }
                            }
                        }
                    }

                    final Response resp = new Response(master, count, isTimerRunning(), getTimerMillis());
                    final String respString = gson.toJson(resp, Response.class);
                    writer.write(respString);
                    writer.flush();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    //-----------REQUEST--------------------------------------------------------
    public class Request {

        public boolean master;
        public boolean start;
        public boolean stop;
        public boolean clear;
        public boolean end;

        public boolean isMaster() {
            return master;
        }

        public void setMaster(boolean master) {
            this.master = master;
        }

        public boolean isStart() {
            return start;
        }

        public void setStart(boolean start) {
            this.start = start;
        }

        public boolean isStop() {
            return stop;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        public boolean isClear() {
            return clear;
        }

        public void setClear(boolean clear) {
            this.clear = clear;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }
    }

    //-----------RESPONSE-------------------------------------------------------
    public class Response {

        public boolean master;
        public long count;
        public boolean running;
        public long time;

        Response(boolean master, long count, boolean timeRunning, long timeMillis) {
            this.master = master;
            this.count = count;
            this.time = timeMillis;
            this.running = timeRunning;
        }

        public boolean isMaster() {
            return master;
        }

        public void setMaster(boolean master) {
            this.master = master;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public boolean isRunning() {
            return running;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }
}
