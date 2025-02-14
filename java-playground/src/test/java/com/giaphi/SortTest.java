package com.giaphi;

import java.util.Random;

import org.testng.annotations.Test;

public class SortTest {
    private int[] getNumbers(int n, int bound) {
        var random = new Random();
        var numbers = new int[n];
        for (var i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(bound);
            System.out.print(numbers[i] + " ");
        }
        return numbers;
    }

    private void printNumbers(int[] numbers) {
        System.out.print("\n");
        for (var number : numbers) {
            System.out.print(number + " ");
        }
    }

    @Test
    void testBubbleSort() {
        var a = getNumbers(10, 100);
        var swapped = false;
        for (var i = 0; i < a.length - 1; i++) {
            System.out.println("\nNew loop");
            swapped = false;
            for (var j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    var t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                    swapped = true;
                    printNumbers(a);
                }
            }
            if (!swapped) break;
        }
        printNumbers(a);
    }

    @Test
    void testSelectionSort1() {
        var a = getNumbers(10, 100);
        for (var i = 0; i < a.length - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            var t = a[minIndex];
            a[minIndex] = a[i];
            a[i] = t;
        }
        printNumbers(a);
    }

    @Test
    void testSelectionSort2() {
        var a = getNumbers(10, 100);
        for (var i = 0; i < a.length - 1; i++) {
            for (var j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    var t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        printNumbers(a);
    }
}
