package com.leetcode.easy.stack_queue;

import common.ListNode;

import java.util.Stack;

/**
 * @Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *  
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/22 12:40
 */
public class MinStack {

    private static class MinStackWithTwoStack  {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        /** initialize your data structure here. */
        public MinStackWithTwoStack() {

        }

        public void push(int x) {
            if (min.isEmpty() || x <= getMin()) {
                min.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if (top() == getMin()) {
                min.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    private static class MinStackWithLinkedList  {
        private ListNode head = null;
        private int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStackWithLinkedList() {

        }

        public void push(int x) {
            if (x <= min) {
                head = new ListNode(min, head);
                min = x;
            }
            head = new ListNode(x, head);
        }

        public void pop() {
            if (top() == getMin()) {
                min = head.next.val;
                head = head.next.next;
            } else {
                head = head.next;
            }
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
