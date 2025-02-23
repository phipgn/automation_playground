package com.giaphi;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    private static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        var n = 6;
        System.out.println(factorial(n));
    }
}

// = f(6)
// = 6 * f(5)
// = 6 * 5 * f(4)
// = 6 * 5 * 4 * f(3)
// = 6 * 5 * 4 * 3 * f(2)
// = 6 * 5 * 4 * 3 * 2 * f(1)
// = 6 * 5 * 4 * 3 * 2 * 1 = 720
