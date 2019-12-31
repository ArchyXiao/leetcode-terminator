package com.leetcode.easy.binarySearch;

/**
 * @Description:
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is
 * returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/20 19:32
 */
public class SqrtX {

    // Time: O(log(n)), Space: O(1)
    public int mySqrt(int x) {
        long low = 0, high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int)mid;
            } else if (square < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    // Time: O(log(n)), Space: O(1)
    // 牛顿迭代法快速寻找平方根
    // 可以很有效地求出根号a的近似值：首先随便猜一个近似值x，然后不断令x等于x和a/x的平均数，迭代个六七次后x的值就已经相当精确
    // (x + a / x) / 2
    public int mySqrt02(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) / 2;
        }
        return (int) n;
    }
}
