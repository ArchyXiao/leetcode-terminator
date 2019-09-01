package edu.sword.refers.base_structure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * @Auther: Archy
 * @Date: 2019/9/1 00:21
 */
public class PrintListFromTailToHead {
     ArrayList<Integer> list = new ArrayList<>();
     class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
         ArrayList<Integer> list = new ArrayList<>();
         ListNode tmp = listNode;
         while (tmp != null) {
             list.add(0, tmp.val);
             tmp = tmp.next;
         }
         return list;
    }

    public ArrayList<Integer> printListFromTailToHead03(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead03(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
