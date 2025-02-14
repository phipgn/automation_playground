package com.giaphi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // var n = 123456;
        // var t = n;
        // var t2 = n;
    
        // var u = 1;
        // do {
        //     t2 = t2 / 10;
        //     u = u * 10;
        // } while(t2 > 1);
        
        // var r = 0;
        // do {
        //     r = r + t % 10 * u;
        //     u = u / 10;
        //     t = t / 10;
        // } while (t > 0);
        
        // System.out.print(r);
        var n = 123456;
        var r = 0;
        while (n > 0) {
            r = r * 10 + n % 10;
            n = n / 10;
        }
        System.out.print(r);
    }
}
