package leetcode.binarysearchtree;


import leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 */

public class N530getMinimumDifference {

    TreeNode pre;
    int minValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);

        return minValue;
    }

    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.left);

        if (pre != null){
            if (root.val - pre.val < minValue){
                minValue = root.val - pre.val;
            }
        }

        pre = root;

        inOrder(root.right);
    }
}
