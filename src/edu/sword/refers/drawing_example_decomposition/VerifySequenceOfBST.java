package edu.sword.refers.drawing_example_decomposition;

import java.util.Stack;

/**
 * @Description: 二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 * 如果是则输出Yes,否则输出No；
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/9 16:04
 */
public class VerifySequenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start == end || start + 1 == end) {
            return true;
        }

        int root = sequence[end - 1];
        int i = start;
        while (i < end - 1 && sequence[i] < root) {
            ++i;
        }

        int mid = i;
        while (i < end - 1 && sequence[i] > root) {
            ++i;
        }

        if (i == end - 1) {
            return verify(sequence, start, mid);
        } else {
            return false;
        }

    }

    public boolean verifyStack(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int root = sequence[sequence.length - 1];
        stack.push(root);

        int lowerBound = Integer.MIN_VALUE;
        for (int i = 0; i <  sequence.length - 1; i++) {
            if (lowerBound > sequence[i]) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < sequence[i]) {
                lowerBound = stack.pop();
            }
            stack.push(sequence[i]);
        }
        return true;
    }

    public boolean verifyArray(int[] sequence) {
            if (sequence == null || sequence.length == 0) {
                return false;
            }

            int[] stack = new int[sequence.length];
            int top = 0;
            stack[top] =  sequence[sequence.length - 1];

            int lowerBound = Integer.MIN_VALUE;
            for (int i = 0; i < sequence.length - 1; i++) {
                if (lowerBound > sequence[i]) {
                    return false;
                }

                while (top != -1 && sequence[i] > stack[top]) {
                    lowerBound = stack[top--];
                }

                stack[++top] = sequence[i];
            }

            return true;
    }

}
