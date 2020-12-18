package common;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int flow = 0;

	// 	采用递归解法
	// 			在进行递归之前我们先遍历得到l1与l2的长度len1与len2;
	//
	// 	递归解法：
	//
	// 	如果len1与len2都为1，那么当前的值应为（l1.val+l2.val）%10,进位更新为（l1.val+l2.val）/10；
	// 	如果len1大于len2，递归计算（l1.next,l2），当前的值应为（l1.val+进位）%10，进位更新为（l1.val+进位）/10；
	// 	如果len1等于len2，递归计算（l1.next,l2.next）,当前的值应为（l1.val+进位+l2.val）%10，进位更新为（l1.val+进位+l2.val）/10；
	// 	返回当前节点的指针
	// 			递归结束
	//
	// 	为方便递归，递归开始前我们保证len1>=len2，另外递归结束后若进位为1，需要新建值为1的头节点
	// （代码没有仔细优化）
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res1 = l1, res2 = l2;
        int len1 = 0, len2 = 0;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        ListNode res = len1 > len2 ? add(res1, res2, len1, len2) : add(res2, res1, len2, len1);
        if (flow == 1) {
            res1 = new ListNode(1);
            res1.next = res;
            return res1;
        }
        return res;
    }

    public ListNode add(ListNode l1, ListNode l2, int len1, int len2) {
        int temp;
        if ((len1 == 1) && (len2 == 1)) {
            temp = l1.val;
            l1.val = (l1.val + l2.val) % 10;
            flow = (temp + l2.val) / 10;
            return l1;
        }
        if (len1 > len2) {
            temp = l1.val;
            l1.next = add(l1.next, l2, len1 - 1, len2);
            l1.val = (temp + flow) % 10;
            flow = (temp + flow) / 10;
            return l1;
        }
        l1.next = add(l1.next, l2.next, len1 - 1, len2 - 1);
        temp = l1.val;
        l1.val = (temp + flow + l2.val) % 10;
        flow = (temp + flow + l2.val) / 10;
        return l1;

    }
}
