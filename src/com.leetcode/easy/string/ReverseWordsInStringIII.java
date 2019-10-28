package com.leetcode.easy.string;

/**
 * @Description:
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/28 18:05
 */
public class ReverseWordsInStringIII {

    // Time: O(n), Space: O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (start < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            for (int i = start, j = end - 1; i < j; i++,j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            start = end + 1;
            end = start;
        }

        return new String(chars);
    }
}
