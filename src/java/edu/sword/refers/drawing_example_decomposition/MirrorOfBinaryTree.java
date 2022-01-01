package edu.sword.refers.drawing_example_decomposition;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/9 09:34
 */
public class MirrorOfBinaryTree {

    // Time: O(n), Space: O(n)
    public TreeNode invertBinaryTreeRecursive(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertBinaryTreeRecursive(root.left);
        invertBinaryTreeRecursive(root.right);

        return root;
    }

    // Time: O(n), Space: O(n)
    public  TreeNode invertBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
