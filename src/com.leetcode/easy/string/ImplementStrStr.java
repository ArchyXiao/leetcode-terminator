package com.leetcode.easy.string;

/**
 * @Description:
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr
 * () and Java's indexOf().
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/25 16:16
 */
public class ImplementStrStr {

    // Time: O((n-m+1)*m), Space: O(1)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.equals("")) {
            return 0;
        }

        int m = needle.length(), n = haystack.length();
        for (int i = 0; i <= n-m; i++) {
            int j = 0, k = i;
            while (j < m && k < n && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
            }
            if (j == m) {
                return i;
            }
        }

        return -1;
    }


}
