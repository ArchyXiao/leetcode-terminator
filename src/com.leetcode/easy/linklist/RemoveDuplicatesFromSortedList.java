package com.leetcode.easy.linklist;

import common.ListNode;

/**
 * @Description:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/1 16:07
 */
public class RemoveDuplicatesFromSortedList {

    // Time: O(n), Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
            next = next.next;
        }
        return head;
    }
}
