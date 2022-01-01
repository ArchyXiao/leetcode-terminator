package edu.sword.refers.drawing_example_decomposition;

import java.util.Stack;

/**
 * @Description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等,
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * (注意：这两个序列的长度是相等的)
 * @Auther: xiaoshude
 * @Date: 2019/9/9 14:25
 */
public class ValidateStackSequences {

    /**
     * @param pushed
     * @param popped
     * @Description: 根据给定序列，模拟出栈入栈的操作；若最终栈为空，说明出栈序列是合法的
     * <p>
     * Time: O(n)
     * Space: O(n)
     * @return: boolean
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for (int item : pushed) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popped[p]) {
                stack.pop();
                p++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * @param pushed
     * @param popped
     * @Description: 利用数组实现
     * <p>
     * Time: O(n)
     * Space: O(n)
     * @return: boolean
     */
    public boolean validateStackSequencesArray(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int[] stack = new int[pushed.length];
        int p = 0, top = -1;
        for (int item : pushed) {
            stack[++top] = item;
            while (top != -1 && stack[top] == popped[p]) {
                top--;
                p++;
            }
        }

        return top == -1;
    }
}
