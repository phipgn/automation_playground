package com.giaphi;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var arr = new int[] { 151, 99, 178, 126, 31, 36, 70, 129, 117, 159 };
        var max = arr[0];
        var second_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                second_max = max;
                max = arr[i];
            } else if (arr[i] > second_max) {
                second_max = arr[i];
            }
        }
    }
}
