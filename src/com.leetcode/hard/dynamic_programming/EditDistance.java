package com.leetcode.hard.dynamic_programming;

/**
 * @Description:
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @Auther: xiaoshude
 * @Date: 2020/4/7 10:22
 */
public class EditDistance {

    // 由其中一个字符串转成另一个所需要的最少编辑操作次数
    // Time: O(m*n), Space: O(m*n)
    public int minDistance(String word1, String word2) {

        int m = word1.length() + 1, n = word2.length() + 1;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = min(d[i-1][j], d[i][j-1], d[i-1][j-1]) + 1;
                }
            }
        }
        return d[m-1][n-1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }


}
