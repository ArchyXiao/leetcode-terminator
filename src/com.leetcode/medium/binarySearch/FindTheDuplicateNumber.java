package binarySearch;

/**
 * @Description:
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 * Input: [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @Auther: Archy
 * @Date: 2019/11/16 22:30
 */
public class FindTheDuplicateNumber {

    // Time: O(n^2), Space: O(1)
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1;  j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // Time: O(n*log(n)), Space: O(1)
    // 抽屉法
    // 数值区间在 1 - n， 数组长度 n + 1
    // 可以对数组进行 log(n) 轮的折半查找，每次都找到中间值 mid (mid 表示抽屉数，即可容纳的不重复数字个数)
    // 找到 mid 值，遍历一轮数组，与 mid 比较并做计数；
    // 若 count > mid，计数值大于当前抽屉数，说明重复数存在于 mid 左侧区间
    // 反之，说明重复数存在于 mid 右侧区间
    public int findDuplicate02(int[] nums) {
        int low  = 1, high = nums.length - 1;
        while (low < high) {
            int  mid = low  + (high - low) / 2;
            int  count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Time: O(n), Space: O(1)
    // 转化为求带环链表入口结点
    // 从下标 0 开始，根据下标从数组读取对应数字，再将读取到的数据作为新的下标，接着从数组中取得链表的下一个结点
    // 数组转换成链表后，链表的头节点是 0，可以理解为是一个虚拟节点
    // 所以 slow、fast、p 初始都是指向数字 0 的（这一点很重要，它们三个必须要从同一个点出发）
    // 但是，由于这里判断相遇用的是 slow 是否等于 fast，所以如果一开始把 slow 和 fast 也初始为 0，就不会进入下面的 while 循环
    // 因此，在进入 while 循环前，我们「手动」为 slow 和 fast 走了一次
    public int findDuplicate03(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int p = 0;
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }
        return slow;
    }
}
