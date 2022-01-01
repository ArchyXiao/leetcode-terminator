package edu.sword.refers.completeness_robustness;

import common.ListNode;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2019/9/8 00:12
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
