package easy.array;

/**
 * @Description:
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @Auther: lenovo
 * @Date: 2019/7/1 12:49
 */
public class TwoSumIIInputArrayIsSorted {
    /**
     * @Description:
     * 【双指针】
     * 利用数组已排序的特性
     * 我们使用两个指针，初始分别位于第一个元素和最后一个元素位置，比较这两个元素之和与目标值的大小。如果和等于目标值，我们发现了这个唯一解。如果比目标值小，我们将较小元素指针增加一。如果比目标值大，我们将较大指针减小一。移动指针后重复上述比较知道找到答案。
     *
     * 时间复杂度：O(n)。每个元素最多被访问一次，共有 n 个元素。
     * 空间复杂度：O(1)。只是用了两个指针。
     *
     * @param nums
     * @param target
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low  < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[] { low, high };
            }
            if (sum > target) {
                high--;
            }
            if (sum < target) {
                low++;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        TwoSumIIInputArrayIsSorted twoSum = new TwoSumIIInputArrayIsSorted();
        int[] ints = twoSum.twoSum(nums, 9);
        for(int i : ints) {
            System.out.println(i);
        }

    }
}
