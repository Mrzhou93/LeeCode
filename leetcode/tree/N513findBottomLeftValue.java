package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N513findBottomLeftValue {

    private int maxDepth = 0;
    private int val ;

    public int findBottomLeftValue(leetcode.TreeNode root) {
        val = root.val;
        dfs(root, 0);

        return val;
    }

    public void dfs(TreeNode root, int depth){
        if (root == null)
            return;

        if (depth > maxDepth){
            maxDepth = depth;
            val = root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
