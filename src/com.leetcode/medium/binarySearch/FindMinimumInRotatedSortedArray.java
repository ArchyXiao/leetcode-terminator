package com.leetcode.medium.binarySearch;

/**
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * @Auther: xiaoshude
 * @Date: 2019/11/18 16:20
 */
public class FindMinimumInRotatedSortedArray {

    // Time: O(log(n)), Space: O(1)
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    // Time: O(log(n)), Space: O(1)
    // 因为查找过程中，最小值始终存在于 low，high 两个游标之间的区间
    // 所以当 nums[low] <= nums[high], nums[low] 必定是该旋转数组中的最小值，可以提前返回
    public int findMin02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    // Time: O(n), Space: O(1)
    public int findMin03(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
