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
public class MyThread2210 extends Thread {
    static int cnt = 0;
 
    public static void main(String[] args) {
        Thread th1 = new MyThread2210();
        Thread th2 = new MyThread2210();
        th1.start();
        th2.start();
    }
 
    public void run() {
        while (true) {
            synchronized (getClass()) {
            System.out.println(cnt++);
            }
        }
    }
}
