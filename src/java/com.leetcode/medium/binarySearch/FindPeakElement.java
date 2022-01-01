package com.leetcode.medium.binarySearch;

/**
 * @Description: A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * <p>
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * <p>
 * Note:
 * Your solution should be in logarithmic complexity.
 * @Auther: xiaoshude
 * @Date: 2019/11/18 19:49
 */
public class FindPeakElement {

    // Time: O(n), Space: O(1)
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    // Time: O(log(n)), Space: O(1)
    public int findPeakElement02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE;
            if (nums[mid] > left && nums[mid] > right) {
                return mid;
            } else if (left > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
