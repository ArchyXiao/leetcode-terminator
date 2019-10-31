package easy.linklist;

import common.ListNode;

/**
 * @Description:
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @Auther: Archy
 * @Date: 2019/11/1 00:46
 */
public class ReverseLinkedList {

    // Time: O(n), Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
