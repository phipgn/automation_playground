package com.giaphi;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var n = 10;
        var numbers = new int[n];
        var random = new Random();
        for (var i = 0; i < n; i++) {
            numbers[i] = random.nextInt(100);
        }

        for (var number : numbers) {
            System.out.print(number + " ");
        }

        for (var i = 0; i < numbers.length - 1; i++) {
            for (var j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    var t = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = t;
                }
            }
        }
        
        System.out.print("\n");
        for (var number : numbers) {
            System.out.print(number + " ");
        }

        
    }
}
