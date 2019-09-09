package edu.sword.refers.drawing_example_decomposition;

import common.ListNode;

import java.util.Stack;

/**
 * @Description: 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @Auther: xiaoshude
 * @Date: 2019/9/9 11:22
 */
public class MinStackWithTwoStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || min() > node) {
            min.push(node);
        }
    }

    public void pop() {
        if (stack.peek() == min()) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

    class MinStackWithLinkedList {
        ListNode head = null;
        int min = Integer.MAX_VALUE;

        public void push(int node) {
            if (node <= min) {
                head = new ListNode(min, head);
                min = node;
            }
            head = new ListNode(node, head);
        }

        public void pop() {
            if (min() == head.val) {
                min = head.next.val;
                head = head.next.next;
            } else {
                head = head.next;
            }
        }

        public int top() {
            return head.val;
        }

        public int min() {
            return min;
        }
    }
}
