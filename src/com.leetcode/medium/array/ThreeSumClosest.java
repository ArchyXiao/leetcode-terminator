package array;

import java.util.Arrays;

/**
 * @Description:
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @Auther: Archy
 * @Date: 2019/10/11 02:05
 */
public class ThreeSumClosest {
    // Time: O(n^2), Space: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int result = 0, min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int k = nums.length-1; k >= 2; --k) {
            int i = 0, j = k-1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    ++i;
                } else {
                    --j;
                }
                int diff = Math.abs(target - sum);
                if (diff < min) {
                    result = sum;
                    min = diff;
                }
            }
        }
        return result;
    }
}
