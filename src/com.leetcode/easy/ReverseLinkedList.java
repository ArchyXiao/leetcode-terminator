import common.ListNode;

/**
 * @Description:
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/2 11:54
 */
public class ReverseLinkedList {

      /**
       * @Description:
       * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
       * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
       * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用
       *
       * 时间复杂度：O(n)。 假设 n 是列表的长度，时间复杂度是 O(n)。
       *
       * 空间复杂度：O(1)
       *
       * @param head
       * @return: ReverseLinkedList.ListNode
       */
     public ListNode reverseList01(ListNode head) {
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
    
     /**
      * @Description:
      * 递归版本关键在于反向工作。
      * 假设列表的其余部分已经被反转，
      * 现在我该如何反转它前面的部分？假设列表为：n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
      * 若从节点 nk+1 到 nm 已经被反转，而我们正处于 nk
      * n1 → … → nk-1 → nk → nk+1 ← … ← nm
      * 我们希望 nk+1 的下一个节点指向 nk。
      * 所以，
      * nk.next.next = nk;
      *
      * 要小心的是 n1 的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
      *
      * 时间复杂度：O(n)。假设 nn 是列表的长度，那么时间复杂度为 O(n)。
      *
      * 空间复杂度：O(n)。由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n层。
      *
      * @param head
      * @return: ReverseLinkedList.ListNode
      */
     public ListNode reverseList02(ListNode head) {
        return reverse(null, head);
     }

     public ListNode reverse(ListNode pre, ListNode cur) {
         if (cur == null) {
             return pre;
         }

         ListNode next = cur.next;
         cur.next = pre;

         return reverse(cur, next);
     }
}
