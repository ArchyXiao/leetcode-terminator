
/**
 * @Description:
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/6 11:36
 */
public class PalindromeLinkedList {
    /**
     * @Description:
     * 用2个指针，一个low，一个fast，fast是low的2倍，所以可以达到2分链表的效果
     *
     * 在移动指针时同时对前半部分链表进行反转。最后直接比较被分开的2个链表
     *
     * 因为不能改变当前slow的next，不然就无法跳到下一个元素，所以这里用pre和prepre实现指针的反转
     *
     * 时间复杂度：第一个循环O(n/2)，第2个循环O(n/2)
     *
     * @param head
     * @return: boolean
     */
    public boolean isPalindrome01(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, first = head.next, pre = null, prepre = null;
        while (first != null || first.next != null) {
            // 先移动指针
            pre = slow;
            slow = slow.next;
            first = first.next.next;
            // 反转前半段链表
            pre.next = prepre;
            prepre = pre;
        }

        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = first == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
