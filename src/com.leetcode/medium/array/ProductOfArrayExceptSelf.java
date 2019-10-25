package com.leetcode.medium.array;

/**
 * @Description:
 * @Auther: xiaoshude
 * @Date: 2019/10/22 19:41
 */
public class ProductOfArrayExceptSelf {
    // Time: O(n), Space: O(n)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        leftProduct[0] = nums[0];
        rightProduct[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i];
        }

        int[] output = new int[n];
        output[0] = rightProduct[1];
        output[n - 1] = leftProduct[n - 2];
        for (int i = 1; i < n - 1; i++) {
            output[i] = leftProduct[i - 1] * rightProduct[i + 1];
        }
        return output;
    }

    // Time: O(n), Space: O(1)
    public int[] productExceptSelf02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int n = nums.length;
        int output[] = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }

}
