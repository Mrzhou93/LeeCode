package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /  \
 *           20   13
 */

public class N538convertBST {

    int preNum;

    public leetcode.TreeNode convertBST(leetcode.TreeNode root) {
        order(root);
        return root;
    }

    public void order(TreeNode root){
        if (root == null)
            return;

        order(root.right);
        root.val += preNum;
        preNum = root.val;
        order(root.left);
    }
}
