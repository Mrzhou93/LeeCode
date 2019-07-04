package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N687longestUnivaluePath {

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        recursion(root);
        return ans;
    }

    public int recursion(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = recursion(root.left);
        int right = recursion(root.right);

        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null && root.val == root.left.val){
            leftMax = left + 1;
        }

        if (root.right != null && root.val == root.right.val){
            rightMax = right + 1;
        }

        ans = Math.max(ans, leftMax + rightMax);

        return Math.max(leftMax, rightMax);
    }
}
