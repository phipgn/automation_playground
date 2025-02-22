package com.giaphi;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var numbers = new int[10];
        var random = new Random();

        numbers = Arrays.stream(numbers).map(n -> random.nextInt(100)).toArray();
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}
