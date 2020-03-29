/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_4.k22_4_1;

/**
 *
 * @author maxio
 */
public class MyThread2209 extends Thread {
    static int cnt = 0;
 
    public static void main(String[] args) {
        Thread th1 = new MyThread2209();
        Thread th2 = new MyThread2209();
        th1.start();
        th2.start();
    }
 
    public void run() {
        while (true) {
            System.out.println(cnt++);
        }
    }
}
