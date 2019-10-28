package com.leetcode.easy.string;

/**
 * @Description:
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that
 * can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/28 16:00
 */
public class LongestPalindrome {

    // Time: O(n), Space: O(m)
    // n 是字符串长度，m 是用于字符编码计数的数组长度
    public int longestPalindrome(String s) {
        int[] ints = new int[256];
        int oddNum = 0;
        for (char c : s.toCharArray()) {
            ints[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (ints[i] % 2 == 1) {
                oddNum++;
            }
        }
        int unUsed = Math.max(0, oddNum - 1);

        return s.length() - unUsed;
    }
}
