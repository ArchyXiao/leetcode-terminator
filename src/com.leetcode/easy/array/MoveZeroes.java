package com.leetcode.easy.array;

/**
 * @Description:
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/14 12:46
 */
public class MoveZeroes {

    // Time: O(n), Space: O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] != 0) {
                nums[slow] = nums[first];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Time: O(n), Space: O(1)
    public void moveZeroes02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[first];
                nums[first] = tmp;

                slow++;
            }
        }
    }
}
