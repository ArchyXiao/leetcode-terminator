package common;

/**
 * @Description: Definition for singly-linked list.
 * @Auther: xiaoshude
 * @Date: 2019/9/9 09:35
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }
}
