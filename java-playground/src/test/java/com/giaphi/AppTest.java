package com.giaphi;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    void testMultiplicationTable() {
        for (var i = 2; i <= 9; i++) {
            for (var j = 2; j <= 9; j++) {
                System.out.print(String.format("%d x %d = %2d | ", j, i, j * i));
            }
            System.out.print("\n");
        }
    }

    /**
     * Write a function in Python that takes an array of integers and returns the second largest number. 
     * The function should handle edge cases where the array might have duplicate numbers or less than two unique numbers.
     */
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
    public void testFindSecondMax() {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(findSecondMax(new int[] { 151, 99, 178, 126, 31, 36, 70, 129, 117, 159 }), 159);
        softAssert.assertEquals(findSecondMax(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }), 1);
        softAssert.assertEquals(findSecondMax(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }), 9);
        softAssert.assertEquals(findSecondMax(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2 }), 1);

    }

    /**
     * Write a Java function that checks if a given string is a palindrome (reads the same forward and backward).
     * The function should be case-insensitive and should ignore non-alphanumeric characters.
     */
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
    public void testIsPalindrome() {
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

    /**
     * Given a sorted array of integers, write a Java function to find the first and last occurrence of a given target number. 
     * If the target is not present, return -1 for both positions. The time complexity should be O(log n).
     * You can use binary search to solve this efficiently. Let me know your solution when you're ready!
     */
    private int findFirstOccur(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;
        var pos = -1;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (arr[mid] == target) {
                pos = mid;
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    private int findLastOccur(int[] arr, int target) {
        var left = 0;
        var right = arr.length - 1;
        var pos = -1;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (arr[mid] == target) {
                pos = mid;
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    private int[] findFirstAndLastOccurs(int[] arr, int target) {
        var first = findFirstOccur(arr, target);
        var last = findLastOccur(arr, target);
        return new int[] { first, last };
    }

    @Test
    public void testFindFirstAndLastOccurs() {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 1, 2, 2, 2, 3, 4, 5 }, 2), new int[] { 1, 3 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 1, 2, 3, 4, 5 }, 3), new int[] { 2, 2 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 1, 2, 3, 4, 5 }, 6), new int[] { -1, -1 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 1, 1, 2, 3, 4, 5 }, 1), new int[] { 0, 1 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 1, 2, 3, 4, 4 }, 4), new int[] { 3, 4 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { 7 }, 7), new int[] { 0, 0 });
        softAssert.assertEquals(findFirstAndLastOccurs(new int[] { }, 1), new int[] { -1, -1 });
        softAssert.assertAll();
    }

    /**
     * Email Validation Ruleset
     * 
     * Username (local part):
     * Can contain letters (a-z, A-Z), digits (0-9), and special characters: ._%+-
     * Cannot start or end with a dot (.)
     * Cannot have consecutive dots (..)
     * 
     * @ Symbol:
     * Must appear exactly once
     * 
     * Domain Name:
     * Must have at least one dot (.) separating the domain and TLD
     * Can contain letters (a-z, A-Z) and digits (0-9)
     * Can have hyphens (-), but not at the beginning or end
     * 
     * Top-Level Domain (TLD):
     * Must be at least 2 characters long (e.g., .com, .org, .co.uk)
     * Only letters (a-z, A-Z) allowed
     */
    private boolean validateEmail(String email) {
        var regex = "^[^.](?!.*\\.\\.)[a-zA-Z0-9._%+-]+[^.]@[^-](?!.*--)[a-zA-Z0-9-]+[^-]\\.[a-zA-Z.]{2,}$";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @DataProvider(name = "emailData")
    public Object[][] getEmails() {
        return new Object[][] {
            {"user@example.com", true},
            {"first.last@example.co.uk", true},
            {"123user@example.org", true},
            {"user_123@example.net", true},
            {"user+alias@example.io", true},
            {"user-name@example.biz", true},
            {"email@sub.domain.com", true},
            {"user@domain.travel", true},
            {"email@domain.museum", true},
            {"user123@example.jobs", true},
            {".user@example.com", false}, // Invalid: Starts with a dot
            {"user..name@example.com", false}, // Invalid: Consecutive dots in local part
            {"user.@example.com", false}, // Invalid: Ends with a dot before @
            {"user@-example.com", false}, // Invalid: Domain starts with hyphen
            {"user@example-.com", false}, // Invalid: Domain ends with hyphen
            {"user@example..com", false}, // Invalid: Consecutive dots in domain
            {"user@example.c", false}, // Invalid: TLD too short
            {"user@exa--mple.com", false}, // Invalid: Consecutive hyphens in domain
            {"user@domain#com", false}, // Invalid: Special character `#` in domain
            {"user@domain.123", false} // Invalid: Numeric TLD
        };
    }

    @Test(dataProvider = "emailData")
    void testValidateEmail(String email, boolean expectedResult) {
        Assert.assertEquals(validateEmail(email), expectedResult);
    }
}
