package com.leetcode.medium.binarySearch;

/**
 * @Description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/18 15:02
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    // Time: O(n), Space: O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        return new int[] {start, end};
    }

    // Time: O(log(n)), Space: O(1)
    // 二分搜索获取目标值的最大下标（结束位置）
    // 间接获得目标值的最小下标（开始位置）
    // 通过二分查找目标值减一的数的下标，并将其加一
    // 最后必须对两个下标值进行校验，因为可能给定数组中不存在 target
    public int[] searchRange02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int end = binarySearchLastPosition(nums, target);
        int start = binarySearchLastPosition(nums, target - 1) + 1;
        if (start >= 0 && start <= end && end < nums.length) {
            return new int[] {start, end};
        } else {
            return new int[] {-1, -1};
        }
    }

    private int binarySearchLastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
