package com.leetcode.easy.array;

/**
 * @Description:
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/16 14:18
 */
public class RotateArray {
    // Time: O(n), Space: O(n)
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length, m = k % n, i = 0;
        int[] t = new int[n];

        // 倒数第 m 个数的索引： n - m
        for (int j = n - m; j < n; j++) {
            t[i++] = nums[j];
        }
        for (int j = 0; j < n - m; j++) {
            t[i++] = nums[j];
        }
        for (int j = 0; j < n; j++) {
            nums[j] = t[j];
        }
    }

    public void rotate02(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int n = nums.length, m = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

