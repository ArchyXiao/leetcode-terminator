package com.leetcode.easy.string;

/**
 * @Description:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/28 12:01
 */
public class ValidPalindrome {

    // Time: O(n), Space: O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        for (; i < j; i++, j--) {

            while (i < j && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }
        if (b >= 'A' && b <= 'Z') {
            b += 32;
        }

        return a == b;
    }
}
