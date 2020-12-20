package array;

/**
 * @Description:
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white, and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Follow up:
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 *
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 *
 * @Auther: Archy
 * @Date: 2020/6/2 21:59
 */
public class SortColors {

    // Time: O(n), Space: O(1)
    public void sortThreeColorsCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num: nums) {
            if (num == 0) {
                ++cnt0;
            } else if (num == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        int j = 0;
        for (int i = 0; i < cnt0; ++i) {
            nums[j++] = 0;
        }
        for (int i = 0; i < cnt1; ++i) {
            nums[j++] = 1;
        }
        for (int i = 0; i < cnt2; ++i) {
            nums[j++] = 2;
        }
    }

    // Time: O(n), Space: O(1)
    public void sortThreeColorsSwap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                swap(nums, mid, right--);
            }
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


}

