package com.giaphi;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var numbers = new int[10];
        var random = new Random();
        for (var i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
            System.out.print(numbers[i] + " ");
        }

        var max = numbers[0];
        for (var i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.println("Max number: " + max);
    }
}
