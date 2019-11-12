package com.leetcode.medium.linklist;

import common.ListNode;

/**
 * @Description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/8 12:17
 */
public class SortList {
    // Time: O(n*log(n)), Space: O(n)
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void swap(ListNode l1, ListNode l2) {
        int tmp = l1.val;
        l1.val = l2.val;
        l2.val = tmp;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) {
            return;
        }
        ListNode fast = head.next, slow = head;
        int pivot = head.val;
        while (fast != end) {
            if (fast.val <= pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, end);
    }

    // Time: O(n*log(n)), Space: O(log(n))
    public ListNode sortList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return dummy.next;
    }
}
