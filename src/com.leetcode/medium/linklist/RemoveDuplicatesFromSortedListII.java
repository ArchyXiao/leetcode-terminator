package com.leetcode.medium.linklist;

import common.ListNode;

/**
 * @Description:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/1 16:40
 */
public class RemoveDuplicatesFromSortedListII {

    // Time: O(n), Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = pre.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = pre.next;
        }
        return dummy.next;
    }
}
