package edu.sword.refers.completeness_robustness;

import common.TreeNode;

/**
 * @Description: 树的子结构
 * 输入两棵二叉树 A，B，判断 B 是不是 A 的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 注意！！！
 * 子树的意思是只要包含了一个结点，就得包含这个结点下的所有节点.
 * 子结构的意思是包含了一个结点，可以只取左子树或者右子树，或者都不取。
 *
 * @Auther: Archy
 * @Date: 2019/9/8 00:44
 */
public class HasSubtree {

    /**
     * @Description:
     * 1. 首先需要判断A,B的根节点是否一样。
     * 2. 如果不一样，判断A的左孩子和B的根节点是否一样，同理可判断A的右孩子和B的根节点是否一样。依次找下去
     *
     * 如果上述情况都不满足则说明不包含
     * 1. 如果找到了A中有值和B中的根节点相同，则比较左右子树是否相同。
     * 2. 如果B为空了，则说明包含
     * 3. 如果A为空了，则说明不包含
     * ---------------------------------- 分割线 -----------------------------------------------------------
     * 第一步：在树 A 中找到和树 B 的根节点的值一样的节点 R
     * 第二步：再判断树 A 中以 R 为根节点的子树是不是包含和树 B 一样的结构。
     *
     *
     * @param root1
     * @param root2
     * @return: boolean
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        // 第一步在树A中查找与根节点一样的节点，实际上就是树的遍历，可以采用递归的方式
        if(root2 == null) {
            return false;
        }
        if(root1 == null && root2 != null) {
            return false;
        }

        return (root1.val == root2.val) && isSubTree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode s, TreeNode t) {
        // 第二步是判断树 A 中以 R 为根节点的子树是不是和树 B 具有相同的结构。
        // 同样，我们也可以用递归的思路来考虑：如果节点 R 的值和树 B 的根节点不相同，则以 R 为根节点的子树和树 B 肯定不具有相同的结点；
        // 如果它们的值相同，则递归地判断它们各自的左右节点的值是不是相同。
        // 递归的终止条件是我们到达了树 Ａ 或者树 B 的叶节点
        if (t == null) {
            return true;
        }
        if (s == null && t != null) {
            return false;
        }
        if (t.val  == s.val) {
            return isSubTree(s.left, t.left) && isSubTree(s.right, t.right);
        }
        return false;
    }
}
