package com.algocasts.sort;

import java.util.Stack;

/**
 * @Description: 验证二叉搜索树的前序遍历序列
 * 这个题目说的是，给你一个不包含重复数字的数组，你要验证它是否为某棵二叉搜索树的前序遍历序列。
 * 比如说，给你的数组是：
 *
 * 4, 1, 0, 2, 8
 *
 * 它是以下二叉搜索树的前序遍历序列，因此要返回 true。
 *
 *      4
 *     / \
 *    1   8
 *   / \
 *  0   2
 *
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/12 14:31
 */
public class PreorderTraversal {
    private boolean verify(int[] nums, int start, int end) {
        if (start  == end || start + 1 == end) {
            return true;
        }

        int root  = nums[start];
        int i = start + 1;
        while (i < end && nums[i] < root) {
            i++;
        }

        int mid = i;
        while (i < end && nums[i] > root) {
            i++;
        }

        if (i == end) {
            return verify(nums, start + 1, mid) && verify(nums, mid, end);
        } else {
            return false;
        }
    }

    // Time: O(n^2), Space: O(n)
    public boolean verifyPreorderDivideConquer(int[] preorder) {
        if (preorder == null) {
            return false;
        }
        return verify(preorder,  0,  preorder.length);
    }

    // Time: O(n), Space: O(n)
    // 利用栈的特性我们可以做到自底向上遍历比较
    // lowBound 存储左子树中最大的值
    public boolean verifyPreorderStack(int[] preorder) {
        if (preorder == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < lowerBound) {
                return false;
            }

            while (!stack.isEmpty() && num > stack.peek()) {
                lowerBound = stack.pop();
            }
            stack.push(num);
        }

        return true;
    }

    // Time: O(n), Space: O(n)
    public boolean verifyPreorderArray(int[] preorder) {
        if  (preorder == null) {
            return false;
        }

        int[] stack = new int[preorder.length];
        int lowerBound = Integer.MIN_VALUE, top = -1;
        for (int num : preorder) {
            if (num < lowerBound) {
                return false;
            }

            while (top != -1 && num > stack[top]) {
                lowerBound = stack[top--];
            }
            stack[++top] = num;
        }

        return true;
    }

    // Time: O(n), Space: O(1)
    public boolean verifyPreorderArrayO1Space(int[] preorder) {
        if  (preorder == null) {
            return false;
        }

        int lowerBound = Integer.MIN_VALUE, top = -1;
        for (int num : preorder) {
            if (num < lowerBound) {
                return false;
            }

            while (top != -1 && num > preorder[top]) {
                lowerBound = preorder[top--];
            }
            preorder[++top] = num;
        }

        return true;
    }
}
