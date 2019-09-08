package edu.sword.refers.completeness_robustness;

/**
 * @Description: 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 *
 * @Auther: Archy
 * @Date: 2019/9/7 23:53
 */
public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @Description:
     * 倒数第 k 个结点的位置就在正数第 (n - k + 1) 位置
     * 此处解法巧妙利用 dummy 在 head 的前一个结点
     *
     * @param head
     * @param k
     * @return: edu.sword.refers.completeness_robustness.RemoveNthFromEnd.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p  = dummy, q = dummy;
        while (k > 0) {
            if (q.next != null) {
                q = q.next;
                k--;
            } else {
                return null;
            }
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;

        return dummy.next;
    }
}
