package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @Auther: lenovo
 * @Date: 2019/6/30 19:44
 */
public class TwoSum {
    /**
     * @Description:
     * 暴力法破解
     * 遍历每个元素 X，找到是否存在一个值与target - X 相等的目标元素
     *
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)
     *
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * @Description:
     * 通过以空间换取速度的方式，我们可以利用哈希表将查找时间从 O(n)降低到 近似O(1)
     * 用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)
     *
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
     * 然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]）是否存在于表中。
     * 注意，该目标元素不能是 nums[i]本身
     *
     * 时间复杂度：O(n)， 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
     *
     * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
     *
     * @param nums
     * @param target
     * @return: int[]
     */
    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map);

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * @Description:
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     *
     * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     *
     * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素
     *
     * @param nums
     * @param target
     * @return: int[]
     */
    public int[] twoSum03(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 5, 7};
        TwoSum twoSum = new TwoSum();
        int[] indices = twoSum.twoSum02(nums, 4);
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }

    }
}
