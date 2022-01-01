package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * Input: 5
 * Output:
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * <p>
 * Tips: a[i, j] = a[i - 1, j - 1] + a[i - 1, j]
 * @Auther: xiaoshude
 * @Date: 2019/10/15 20:07
 */
public class PascalTriangle {

    // Time: O(n^2), Space: O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = Arrays.asList(new Integer[i + 1]);
            subList.set(0, 1);
            subList.set(i, 1);
            for (int j = 1; j < i; j++) {
                subList.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(subList);
        }
        return result;
    }
}
