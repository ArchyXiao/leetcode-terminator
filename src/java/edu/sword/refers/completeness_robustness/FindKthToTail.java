package edu.sword.refers.completeness_robustness;

import common.ListNode;

/**
 * @Description: 链表中倒数第 k 个结点
 * 输入一个链表，输出该链表中倒数第 k 个结点。
 *
 * @Auther: Archy
 * @Date: 2019/9/7 22:17
 */
public class FindKthToTail {

    /**
     * @Description:
     * 设置两个指针，p2 指针先走（k-1）步，然后再一起走，当 p2 为最后一个时，p1 就为倒数第 k 个数
     * 相当于制造了一个K长度的尺子，把尺子从头往后移动，当尺子的右端与链表的末尾对齐的时候，尺子左端所在的结点就是倒数第k个结点
     *
     * @param head
     * @param k
     * @return: edu.sword.refers.completeness_robustness.FindKthToTail.ListNode
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p = head, q = head;
        while (k > 1) {
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

        return p;
    }
}
