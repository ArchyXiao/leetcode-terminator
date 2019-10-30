package com.leetcode.medium.string;

/**
 * @Description:
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/29 11:54
 */
public class ReverseWordsInString {
    // Time: O(n), Space: O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int p = 0, q = 0, end = chars.length - 1;
        while (end >= 0 && chars[end] == ' ') {
            end--;
        }
        while (q <= end) {
            // the start position of a word
            int start = p;
            // skip spaces
            while (q <= end && chars[q] == ' ') {
                q++;
            }
            // copy a word
            while (q <= end && chars[q] != ' ') {
                chars[p++] = chars[q++];
            }
            // reverse the word
            reverse(chars, start, p - 1);
            // make a space
            if (q <= end) {
                chars[p++] = ' ';
            }
        }
        // reverse the whole string, 0 ~ p-1
        reverse(chars, 0, p - 1);
        return new String(chars, 0, p);
    }

    private void reverse(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}

