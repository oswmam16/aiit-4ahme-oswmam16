/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k22.k22_3.k22_3_2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author maxio
 */
public class MyThread2208 {
    public static void main(String[] args) {
        MyThread2205 th;
        BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            new DataInputStream(System.in)));
        int num;
 
        try {
            while (true) {
                System.out.print("Bitte eine Zahl eingeben: ");
                System.out.flush();
                num = (new Integer(in.readLine())).intValue();
                if (num == -1) {
                    break;
                }
                th = new MyThread2205();
                th.printPrimeFactors(num);
            }
        } catch (IOException e) {
        }
    }
}
