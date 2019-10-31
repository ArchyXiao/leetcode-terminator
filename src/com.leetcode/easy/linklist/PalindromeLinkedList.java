package com.leetcode.easy.linklist;

import common.ListNode;

import java.util.Stack;

/**
 * @Description:
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/31 12:38
 */
public class PalindromeLinkedList {

    // Time: O(n), Space: O(n)
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode p = head; p != null; p = p.next) {
            stack.push(p.val);
        }
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Time: O(n), Space: O(1)
    public boolean isPalindrome02(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }

        ListNode pre = null, cur = head;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (len % 2 == 1) {
            cur = cur.next;
        }

        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) {
                return false;
            }
        }
        return true;
    }
}
