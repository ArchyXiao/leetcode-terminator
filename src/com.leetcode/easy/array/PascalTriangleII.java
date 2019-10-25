package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/16 09:39
 */
public class PascalTriangleII {

    // Time: O(n^2), Space: O(1)
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (rowIndex < 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> subList = Arrays.asList(new Integer[i + 1]);
            subList.set(0, 1);
            subList.set(i, 1);
            for (int j = 1; j < i; j++) {
                subList.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(subList);
        }
        return result.get(rowIndex);
    }
}
