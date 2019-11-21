package com.leetcode.medium.binarySearch;

/**
 * @Description:
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *  
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/21 19:45
 */
public class SingleElementInSortedArray {

    //  Time: O(n), Space: O(1)
    // 成对的数异或操作后，结果为零
    // 剩余的值即为单身数
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Time: O(log(n)), Space: O(1)
    // 有序数组中，当中间数与左右两侧的值不相等时，那么该数为单身数
    // 当中间数非单身数时，保持 mid 游标在靠左的位置（利于判断下一步 low，high 游标移动方向）
    // mid - low ，即为 mid 游标右侧数值个数
    // 若为偶数，说明单身数存在于 mid 右侧区间
    // 若为奇数，说明单身数存在于 mid 左侧区间
    // 注意，由于 mid 游标每次都处于靠左位置，所以右移时必须 +2
    public int singleNonDuplicate02(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                mid--;
            } else if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {

            } else {
                return nums[mid];
            }

            if ((mid - low) % 2 == 0) {
                low = mid + 2;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
