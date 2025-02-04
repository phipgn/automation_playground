package com.giaphi;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private int findSecondMax(int[] arr) {
        var max = Integer.MIN_VALUE;
        var second_max = max;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                second_max = max;
                max = arr[i];
            } else if (arr[i] > second_max) {
                second_max = arr[i];
            }
        }
        return second_max;
    }

    @Test
    public void findSecondMax() {
        Assert.assertEquals(findSecondMax(new int[] { 151, 99, 178, 126, 31, 36, 70, 129, 117, 159 }), 159);
    }

    private boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        
        var str_original = str.toLowerCase().replaceAll("[^a-zA-Z]", "");
		var str_reversed = new StringBuilder();
		
		for (var i = str_original.length() - 1; i >= 0; i--) {
		    str_reversed.append(str_original.charAt(i));
		}
		
		System.out.println(str_reversed.toString());
		return str_original.equals(str_reversed.toString());
    }

    @Test
    public void isPalindrome() {
        var softAssert = new SoftAssert();
        softAssert.assertTrue(isPalindrome("abba"));
        softAssert.assertTrue(isPalindrome("racecar"));
        softAssert.assertTrue(isPalindrome("A man, a plan, a canal, Panama"));
        softAssert.assertTrue(isPalindrome("No 'x' in Nixon"));
        softAssert.assertFalse(isPalindrome("hello"));
        softAssert.assertTrue(isPalindrome("a"));
        softAssert.assertTrue(isPalindrome(""));
        softAssert.assertTrue(isPalindrome("mad am"));
        softAssert.assertAll();
    }
}
