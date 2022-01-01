package linklist;

import common.ListNode;

/**
 * @Description:
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 *
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * @Auther: Archy
 * @Date: 2019/11/1 01:00
 */
public class RotateList {

    // Time: O(n), Space: O(1)
    // k 大于 n 的情况下存在重复旋转操作，直接取余再进行操作
    // 遍历链表两次
    // 第一次先作计数，并且将尾结点指向头结点，使链表成环
    // 第二次从头结点开始，移动 n - k - 1 个位置，确定新的尾结点，保存尾结点的下一个结点作为新的头结点
    // newEnd.next 置空，返回 newHead
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        int n = 1;
        ListNode end = head;
        for (; end.next != null; end = end.next) {
            n++;
        }
        end.next = head;

        k %= n;
        ListNode newEnd = head;
        for (int i = 0; i < n - k - 1; i++) {
            newEnd = newEnd.next;
        }
        ListNode newHead = newEnd.next;
        newEnd.next = null;

        return newHead;
    }
}
