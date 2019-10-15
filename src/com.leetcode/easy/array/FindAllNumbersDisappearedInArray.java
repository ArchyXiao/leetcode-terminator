package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/15 15:20
 */
public class FindAllNumbersDisappearedInArray {

    // Time: O(n), Space: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        boolean existed[] = new boolean[nums.length];
        for (int num : nums) {
            existed[num - 1] = true;
        }
        for (int i = 0; i < existed.length; i++) {
            if (!existed[i]) {
                result.add(i + 1);
            }
        }

        return result;
    }

    // Time: O(n), Space: O(1)
    public List<Integer> findDisappearedNumbers02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
