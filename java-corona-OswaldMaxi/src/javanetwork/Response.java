/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetwork;

/**
 *
 * @author maxio
 */
public class Response {
    private boolean master;
    private long count;
    private boolean running;
    private long time;
    
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
