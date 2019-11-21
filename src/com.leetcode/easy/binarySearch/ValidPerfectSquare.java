package com.leetcode.easy.binarySearch;

/**
 * @Description:
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/21 19:38
 */
public class ValidPerfectSquare {

    // Time: O(log(num)), Space: O(1)
    public boolean isPerfectSquare(int num) {
        long low = 0, high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long mid2 = mid * mid;
            if (mid2 == num) {
                return true;
            } else if (mid2 > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // Time: O(log(num)), Space: O(1)
    public boolean isPerfectSquare02(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
