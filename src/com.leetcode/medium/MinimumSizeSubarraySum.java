package com.leetcode.medium;

/**
 * @Description:
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/29 18:30
 */
public class MinimumSizeSubarraySum {

    /**
     * @Description:
     * 把所有可能的子数组求和并更新 ans ，直到我们找到最优子数组且和满足 sum≥s
     *
     * 初始化 ans = INT_MAX
     * 用变量 i 从左到右遍历数组
     * 用变量 j 从当前元素到数组尾部遍历
     * 将 i 到 j 这些元素求和得到 sum
     * 如果和 sum 比 s 大，更新 ans=min(ans,(j−i+1))
     * 继续迭代
     *
     * 对数组里的每一个元素，我们从它开始枚举所有的子数组，需要的时间为 O(n^2)
     * 将每一个子数组求和的时间复杂度为：O(n)
     * 时间复杂度为：O(n^2 * n) = O(n^3)
     * 空间复杂度：O(1)。只是用了常数个额外变量
     *
     * @param s
     * @param nums
     * @return: int
     */
    public int minSubArrayLen01(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }

        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    /**
     * @Description:
     * 在方法 1 中，我们注意到求子数组的和需要的时间为 O(n) 。我们其实可以很容易地实现 O(1) 时间的求和，只需要从开始元素用一个累加器保存和。
     * 我们将累积和保存在 sums 中，通过这种方法，我们可以轻松求出任意子区间的和。
     * 唯一的不同是求子数组的和：
     * 建立一个大小为 nums 的向量 sums
     * 初始化 sums[0] = nums[0]
     * 遍历向量 sums ：
     * 更新 sums[i] = sums[i−1] + nums[i]
     * 从 i 到 j 的和计算方法：
     * sum = sums[j] − sums[i] + nums[i] ，其中 sums[j] − sums[i] 是从第 i+1 个元素到第 j 个元素的和。
     *
     * 时间复杂度：O(n^2)
     * 找到所有子数组的时间复杂度为 O(n^2)
     * 计算子数组的和为 O(1) 的时间。
     * 因此，总时间复杂度为：O(n^2 * 1) = O(n^2)
     *
     * 空间复杂度：O(n)。
     *
     * @param s
     * @param nums
     * @return: int
     */
    public int minSubArrayLen02(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    /**
     * @Description:
     * 我们可以用二分查找的方法优化方法 2 。我们找到从下标 i 开始满足 sum≥s 的子数组需要 O(n) 的时间。
     * 可以用二分查找的方法把这个时间优化到 O(log(n)) 。在方法 2 中，我们从 i 开始找 j ，直到找到 sums[j] − sums[i] + nums[i] 大于等于 s 的。
     * 与其线性地查找这个和，我们可以使用二分搜索的方法找到 sums 中不小于 sums[i] − nums[i] 的第一个 sums[j] ，可以用 C++ STL 中的 lower_bound 函数做到。
     *
     * 创建大小为 n+1 的数组 sums：
     * sums[0] = 0, sums[i] = sums[i − 1] + nums[i − 1]
     * 从 i=1 到 n 枚举：
     * 在 sums 中找到值 to_find ，满足从 i 开始到这个位置的和大于等于 s 且是最小子数组：
     * to_find = s + sums[i − 1]
     * 在 sums 中找到值满足大于等于 to_find 的下标，记作 bound
     * 如果我们在 \text{sums}sums 中找到了值 {to_find}， 那么：
     * 当前子数组的大小为：
     * bound - sums.begin()+ i - 1
     * 将 ans 与当前数组的大小做比较，并把较小值保存到 ans 中
     *
     *
     * 时间复杂度：O(nlog(n))
     * 对向量中的每一个元素，从它开始用二分查找找到子数组，满足和大于 s 。因此，遍历的时间复杂度是 O(n) ，二分查找的时间复杂度是 O(log(n))
     * 因此，总时间复杂度是 O(n∗log(n))
     *
     * 空间复杂度：O(n) 。sums 需要额外的 O(n) 空间。
     *
     * @param s
     * @param nums
     * @return: int
     */
    public int minSubArrayLen03(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int low = i, high = n;
            for (int j = low; j < high; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
