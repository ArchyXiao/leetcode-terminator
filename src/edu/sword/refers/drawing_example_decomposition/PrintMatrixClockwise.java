package edu.sword.refers.drawing_example_decomposition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/9 10:19
 */
public class PrintMatrixClockwise {

    public List<Integer> spiralOrder(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }

            for (int i = top;  i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right <left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }

        }
        return res;
    }
}
