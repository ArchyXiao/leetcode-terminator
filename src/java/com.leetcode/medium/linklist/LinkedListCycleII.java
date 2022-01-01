package linklist;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 *
 * @Auther: Archy
 * @Date: 2019/11/3 03:37
 */
public class LinkedListCycleII {

    // Time: O(n), Space: O(n)
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set  = new HashSet<>();
        for (ListNode p = head; p.next != null; p = p.next) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
        }
        return null;
    }

    // Time: O(n), Space: O(1)
    // 快慢指针相遇后，p 指针从 head 开始，跟慢指针一起往后移动
    // p 与 slow 相遇时的节点正好会是进入 cycle 的点
    public ListNode detectCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                for (ListNode p = head; p != slow; p = p.next) {
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
