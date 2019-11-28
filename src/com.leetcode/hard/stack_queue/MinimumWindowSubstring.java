package com.leetcode.hard.stack_queue;

/**
 * @Description:
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/27 19:43
 */
public class MinimumWindowSubstring {

    // Time: O(n), Space: O(m)
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE, requireCnt = t.length();
        int[] required = new int[256];
        for (int i = 0; i < t.length(); i++) {
            required[t.charAt(i)]++;
        }

        for (; right < s.length(); right++) {
            char r = s.charAt(right);
            if (required[r] > 0) {
                requireCnt--;
            }
            required[r]--;

            while (requireCnt == 0) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                }
                char l = s.charAt(left);
                required[l]++;
                if (required[l] > 0) {
                    requireCnt++;
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
