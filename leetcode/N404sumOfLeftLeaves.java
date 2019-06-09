package leetcode;

/**
 计算给定二叉树的所有左叶子之和。

 示例：

     3
    / \
   9  20
  /     \
 15      7

 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */

public class N404sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int left = 0, right = 0, cur = 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
            cur = root.left.val;
        else
            left = sumOfLeftLeaves(root.left);
        right = sumOfLeftLeaves(root.right);
        return left + right + cur;
    }
}
