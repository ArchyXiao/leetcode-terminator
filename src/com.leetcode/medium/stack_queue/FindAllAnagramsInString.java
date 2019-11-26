package com.leetcode.medium.stack_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".\
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/26 14:06
 */
public class FindAllAnagramsInString {

    // Time: O(n*k), Space: O(k)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int pLen = p.length(), sLen = s.length();
        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i = 0; i < pLen; i++) {
            sc[s.charAt(i) - 'a']++;
            pc[p.charAt(i) - 'a']++;
        }
        if (equals(sc, pc)) {
            result.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sc[s.charAt(i) - 'a']++;
            sc[s.charAt(i-pLen) - 'a']--;
            if (equals(sc, pc)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }

    private boolean equals(int[] sc, int[] pc) {
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != pc[i]) {
                return false;
            }
        }
        return true;
    }

    // Time: O(n), Space: O(k)
    public List<Integer> findAnagramsOn(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int sLen = s.length(), pLen = p.length();
        char[] pc = new char[26];
        for (int i = 0; i < pLen; ++i) {
            pc[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        while (right < sLen) {
            if (pc[s.charAt(right) - 'a'] > 0) {
                pc[s.charAt(right) - 'a']--;
                ++right;
            } else {
                pc[s.charAt(left) - 'a']++;
                ++left;
            }
            if (right - left == pLen) {
                result.add(left);
            }
        }
        return result;
    }
}
