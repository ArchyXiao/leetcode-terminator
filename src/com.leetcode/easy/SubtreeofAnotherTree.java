package com.leetcode.easy;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 *
 * @Auther: Archy
 * @Date: 2019/9/8 12:22
 */
public class SubtreeofAnotherTree {

    /**
     * @Description: 递归法
     * 考虑递归解法，则首先考虑如何分解问题。
     * 题目给出s和t两树，让我们求解t是不是s的子树，那么：
     *
     * t就等于s本身
     * t是s的左子树的子树
     * t是s的右子树的子树
     *
     * 也就是递归体在于以上三步，因此，根据第一点，我们需要一个判断两树相等的函数（同样使用递归）
     *
     * 问题变成：我们如何判断两树（l、r）相等呢？
     *
     * 根节点值相等
     * l的左子树和r的左子树相等
     * l的右子树和r的右子树相等
     *
     * Time: O(m * n)
     * Space: O(h)
     *
     * @param s
     * @param t
     * @return: boolean
     */
    public boolean isSubTree(TreeNode s, TreeNode t) {
        return isEqual(s, t) || isSub(s.left, t) || isSub(s.right, t);
    }

    /**
     * @Description: 判断两树是否相等
     * @param s
     * @param t
     * @return: boolean
     */
    private boolean isEqual(TreeNode s, TreeNode t) {
        //两树均空自然相等
        if (s == null && t == null) {
            return true;
        }
        //一空一非空，自然不等
        if (s == null || t == null) {
            return false;
        }
        //递归判断
        // return s.val == t.val &&
                // isEqual(s.left, t.left) &&
                // isEqual(s.right, t.right);
        if (s.val == t.val) {
            return isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }
        return false;
    }

    /**
     * @Description: 判断 t 树是否是 s 树的子树
     * @param s
     * @param t
     * @return: boolean
     */
    private boolean isSub(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isEqual(s, t) || isSub(s.left, t) || isSub(s.right, t);
        }

        // 根节点不同，那么就不用考虑s和t相等的情形
        return isSub(s.left, t) || isSub(s.right, t);
    }

    /**
     * @Description: 哈希法
     *
     * Time: O(m + n)
     * Space: O(m + n)
     *
     * @param s
     * @param t
     * @return: boolean
     */
    private static Map<TreeNode, Integer> map = new HashMap<>();

    public static boolean isSubtreeHash(TreeNode s, TreeNode t) {
        System.out.println("s output >>>>>>>>>>>>>>>>>>>>>>");
        computeHash(s);

        System.out.println("t output >>>>>>>>>>>>>>>>>>>>>>");
        computeHash(t);

        return isSubHash(s, t);
    }


    public static String computeHash(TreeNode t) {
        if (t == null) {
            return "#";
        }

        String left = computeHash(t.left);
        String right = computeHash(t.right);
        String hash = left + t.val + right;
        map.put(t, hash.hashCode());

        System.out.println(hash);

        return hash;
    }

    public static boolean isSubHash(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return map.get(s).equals(map.get(t)) || isSubHash(s.left, t) || isSubHash(s.right, t);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(16);

        TreeNode target = new TreeNode(2);
        target.left = new TreeNode(8);
        target.right = new TreeNode(16);

        System.out.println(isSubtreeHash(root, target));
    }
}
