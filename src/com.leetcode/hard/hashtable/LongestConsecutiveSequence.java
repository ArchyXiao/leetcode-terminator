package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 *
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @Auther: Archy
 * @Date: 2019/11/29 22:01
 */
public class LongestConsecutiveSequence {

    // Time: O(n*log(n)), Space: O(1)
    // 基于比较的排序，是主要的消耗点
    // 排序后的数组是一个非递减序列，可以利用一个游标和一个额外字段，来完成最大递增子序列统计
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0, p = 0;
        while (p < nums.length) {
            int len = 1;
            while (p < nums.length - 1) {
                if (nums[p + 1] - nums[p] > 1) {
                    break;
                }
                if (nums[p + 1] - nums[p] == 1) {
                    len++;
                }
                p++;
            }
            max = Math.max(max, len);
            p++;
        }
        return max;
    }

    // Time: O(n), Space: O(n)
    public int longestConsecutive02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int  i = 0; i < nums.length && !set.isEmpty(); i++) {
            int low = nums[i], high = nums[i];
            while (set.contains(--low)) {
                set.remove(low);
            }
            while (set.contains(++high)) {
                set.remove(high);
            }
            max = Math.max(max, high - low - 1);
        }
        return max;
    }

}
