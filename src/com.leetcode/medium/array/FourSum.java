package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b
 * + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @Auther: Archy
 * @Date: 2019/10/13 02:22
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for (int p = nums.length - 1; p >= 3; p--) {
            if (4 * nums[p] < target) {
                break;
            }
            for (int k = p - 1; k >= 2; k--) {
                if (3 * nums[k] + nums[p] < target) {
                    break;
                }
                int sum = target - nums[p] - nums[k];
                int i = 0, j = k - 1;
                while (i < j) {
                    if (sum == nums[i] + nums[j]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[p]));
                        // 结果去重必须在获取符合条件的四元组之后，且在游标移动之前，否则会错过正确结果或者因游标移动可能直接跳过有重复值的情况
                        while (i < j && nums[i + 1] == nums[i]) {
                            i++;
                        }
                        while (i < j && nums[j - 1] == nums[j]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if (sum > nums[i] + nums[j]) {
                        i++;
                    } else {
                        j--;
                    }
                }
                while (k >= 2 && nums[k - 1] == nums[k]) {
                    k--;
                }
            }
            while (p >= 3 && nums[p - 1] == nums[p]) {
                p--;
            }
        }
        return result;
    }
}
