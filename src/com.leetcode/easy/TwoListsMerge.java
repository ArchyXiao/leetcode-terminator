import common.ListNode;

/**
 * @Description:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/5 19:27
 */
public class TwoListsMerge {

    /**
     * @Description:
     * 我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
     *   list1[0]+merge(list1[1:],list2)  list1[0]<list2[0]
     *   list2[0]+merge(list1,list2[1:])  otherwise
     * 也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
     *
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。
     * 如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     *
     * 时间复杂度：O(n + m)。
     * 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。
     * 所以，时间复杂度与合并后的链表长度为线性关系。
     *
     * 空间复杂度：O(n + m)。
     * 调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + m 个栈帧会消耗 O(n + m)的空间。
     *
     * @param l1
     * @param l2
     * @return: TwoListsMerge.ListNode
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists01(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists01(l1, l2.next);
            return l2;
        }
    }

    /**
     * @Description:
     * 首先，我们设定一个哨兵节点 "prehead" ，这可以在最后让我们比较容易地返回合并后的链表。
     * 我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。
     * 然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前位置的值小于等于 l2 ，我们就把 l1 的值接在 prev 节点的后面同时将 l1 指针往后移一个。
     * 否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都把 prev 向后移一个元素。
     *
     * 在循环终止的时候， l1 和 l2 至多有一个是非空的。
     * 由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
     * 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。
     *
     * 时间复杂度：O(n + m) 。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， while 循环的次数等于两个链表的总长度。所有其他工作都是常数级别的，所以总的时间复杂度是线性的。
     *
     * 空间复杂度：O(1) 。迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的。
     *
     * @param l1
     * @param l2
     * @return: TwoListsMerge.ListNode
     */
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
