package com.leetcode.medium.linklist;

import common.ListNode;

/**
 * @Description:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @Auther: xiaoshude
 * @Date: 2019/11/12 15:57
 */
public class PartitionList {
    // Time: O(n), Space: O(1)
    // 快排 Partition 函数基于交换，不能保持元素相对次序不变
    // 可以利用指针在 O(1) 时间内将两个链表连接在一起
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode smaller = new ListNode(0), greater = new ListNode(0);
        ListNode ps = smaller, pg = greater;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                ps.next = p;
                ps = ps.next;
            } else {
                pg.next = p;
                pg = pg.next;
            }
        }
        ps.next = greater.next;
        pg.next = null;

        return smaller.next;
    }
}
