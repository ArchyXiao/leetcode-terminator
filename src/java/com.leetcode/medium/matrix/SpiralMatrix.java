package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/23 16:02
 */
public class SpiralMatrix {

    // Time: O(m*n), Space: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result  = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }

            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            if (left > --right) {
                break;
            }

            for (int m = right; m >= left; m--) {
                result.add(matrix[bottom][m]);
            }
            if (--bottom < top) {
                break;
            }

            for (int n = bottom; n >= top; n--) {
                result.add(matrix[n][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }
}
