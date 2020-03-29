/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_4.k22_4_2;

/**
 *
 * @author maxio
 */
class Counter2212 {
    int cnt;
 
    public Counter2212(int cnt) {
        this.cnt = cnt;
    }
 
    public synchronized int nextNumber() {
        int ret = cnt;
        //Sumulatoin einiger zeitaufwändiger Rechnungen
        double x = 1.0, y, z;
        for (int i= 0; i < 1000; ++i) {
            x = Math.sin((x*i%35)*1.13);
            y = Math.log(x+10.0);
            z = Math.sqrt(x+y);
        } // Wert gefunden
        cnt++;
        return ret;
    }
}
 
public class MyThread2212 extends Thread {
    private String name;
    private Counter2212 counter;
 
    public MyThread2212(String name, Counter2212 counter) {
        this.name = name;
        this.counter = counter;
    }
    
    public static void main(String[] args) {
        Thread[] t = new Thread[5];
        Counter2212 cnt2212 = new Counter2212(10);
        for (int i = 0; i < 5; ++i) {
            t[i] = new MyThread2212("Thread-" + i,cnt2212);
            t[i].start();
        }
    }
 
    public void run() {
        while (true) {
            System.out.println(counter.nextNumber() + " for " + name);
        }
    }
}