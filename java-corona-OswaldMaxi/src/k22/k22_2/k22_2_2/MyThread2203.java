/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_2.k22_2_2;

/**
 *
 * @author maxio
 */
public class MyThread2203 extends Thread {
    int cnt = 0;
    public void run() {
        while (true) {
            if (isInterrupted()) {
                break;
            }
            printLine(++cnt);
        }
    }

    private void printLine(int cnt) {
        System.out.print(cnt + ": ");
        for (int i = 0; i < 30; ++i) {
            System.out.print(i == cnt % 30 ? "* " : ". ");
        }
        System.out.println();
        try {
            Thread.sleep(100); // 100 ms warten
        } catch (InterruptedException e) {
            interrupt();
        }
    }
    
    public static void main(String[] args) {
        MyThread2203 th = new MyThread2203(); { 
            th.start();
            try {
                Thread.sleep(2000); // 2 Sekunden warten
            } catch (InterruptedException e) {
            } 
            th.interrupt(); //Thread unterbrechen
        }
    }
}
