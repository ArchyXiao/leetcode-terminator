package array;

import java.util.*;

/**
 * @Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @Auther: lenovo
 * @Date: 2019/7/8 14:47
 */
public class ThreeSum {

    // Time: O(n^3), Space: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                for (int k = j+1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> elem = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (set.contains(elem)) {
                            continue;
                        }
                        set.add(elem);
                        result.add(elem);
                    }
                }
            }
        }

        return result;
    }

    /**
     * @Description:
     * 排序 + 双指针 + 剪枝
     *
     * 首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为nums[L]和nums[R]，计算三个数的和sum判断是否满足为 0，满足则添加进结果集
     * 如果nums[i] 大于 0，则三数之和必然无法等于 0，结束循环
     * 如果nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
     * 时间复杂度：O(n^2)，n为数组长度
     *
     * @param nums
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums);

        // 优化1: 整个数组同符号，则无解
        if (nums[0] <= 0 && nums[len - 1] >= 0) {
            for(int i = 0; i < len; i++) {
                // 优化2: 最左值为正数则一定无解
                if (nums[i] > 0) {
                    break;
                }
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        // 去重
                        while (L < R && nums[L + 1] == nums[L]) {
                            L++;
                        }
                        // 去重
                        while (L < R  && nums[R - 1] == nums[R]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (sum > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }

        return ans;
    }

    // Time: O(n^2), Space: O(1 )
    public static List<List<Integer>> threeSum03(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = nums.length - 1; k >= 2; k--) {
            if (nums[k] < 0) {
                break;
            }
            int target = -nums[k], i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i + 1] == nums[i]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }

            while (k >= 2 && nums[k - 1] == nums[k]) {
                k--;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        // int[] nums = new int[] { 0, 0, 0, 0, 0 };
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = threeSum02(nums);
        System.out.println(ans);
    }
}








































































