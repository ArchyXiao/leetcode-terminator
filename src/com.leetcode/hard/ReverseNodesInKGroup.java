import java.util.List;

/**
 * @Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * @Auther: Archy
 * @Date: 2019/8/24 20:27
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @Description:
     * 链表分区: 已翻转部分 + 待翻转部分 + 未翻转部分
     *
     * 每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
     * 需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
     * 初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
     * 经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
     * 翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
     * 特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
     * 时间复杂度为 O(n*K) 最好的情况为 O(n) 最差的情况未 O(n^2)
     * 空间复杂度为 O(1) 除了几个必须的节点指针外，我们并没有占用其他空间
     *
     * @param head
     * @param k
     * @return: ReverseNodesInKGroup.ListNode
     **/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode next = end.next;
            end.next = null;
            ListNode start = prev.next;
            prev.next = reverse(start);

            start.next = next;
            prev = start;
            end = prev;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
