package easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Given a non-negative integer c, your task is to decide whether there're two integers a and b such
 * that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 *  
 * @Auther: Archy
 * @Date: 2019/10/13 03:50
 */
public class SumOfSquareNumbers {


    //TODO 理解平方数原理实现
    private boolean isSquare(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    // Time: O(c ^ 1/2), Space: O(1)
    public boolean judgeSquareSum(int c) {
        int x = (int) Math.sqrt(c);
        for (int i = 0; i <= x; ++i) {
            if (isSquare(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    // Time: O(c ^ 1/2), Space: O(c ^ 1/2)
    public boolean judgeSquareSumHashSet(int c) {
        int x = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= x; ++i) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    // Time: O(c ^ 1/2), Space: O(1)
    public boolean judgeSquareSumTwoPointer(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }

    // Time: O(c ^ 1/2), Space: O(1)
    public boolean judgeSquareSumMath(int c) {
        for (int i = 2; i * i <= c; ++i) {
            int cnt = 0;
            while (c % i == 0) {
                ++cnt;
                c /= i;
            }
            if (i % 4 == 3 && (cnt & 1) == 1) {
                return false;
            }
        }
        return c % 4 != 3;
    }
}
