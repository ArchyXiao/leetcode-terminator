package linklist;

import common.ListNode;

/**
 * @Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @Auther: Archy
 * @Date: 2020/8/1 00:44
 */
public class SwapNodesInPairs {

    // Time: O(n), Space: O(n)
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsRecursive(next.next);
        next.next = head;
        return next;
    }

    // Time: O(n), Space: O(1)
    public ListNode swapPairsIterative(ListNode head) {
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next, second = pre.next.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
        }
        return dummy.next;
    }
}
