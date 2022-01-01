package com.leetcode.easy.string;

/**
 * @Description:
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a
 * palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/28 16:20
 */
public class PalindromeNumber {
    // Time: O(m), Space: O(1)
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Time: O(m), Space: O(1)
    public boolean isPalindrome02(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        long y = 0;
        while (tmp > 0) {
            int num = tmp % 10;
            y = y * 10 + num;
            tmp /= 10;
        }

        return x == y;
    }

}
