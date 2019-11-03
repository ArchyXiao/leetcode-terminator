package easy.linklist;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * @Auther: Archy
 * @Date: 2019/11/3 03:24
 */
public class LinkedListCycle {

    // Time: O(n), Space: O(n)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; p.next != null; p = p.next) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
        return false;
    }

    // Time: O(n), Space: O(1)
    public boolean hasCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
