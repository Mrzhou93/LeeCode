package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

public class N257binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();

        findPath(res, root, "");

        return res;
    }

    public void findPath(List<String> res, TreeNode root, String str){
        if (root != null)
            str = str + root.val;

        if (root.left == null && root.right == null)
            res.add(str.toString());

        if (root.left != null) {
            String str1  = str + "->";
            findPath(res, root.left, str1);
        }

        if (root.right != null){
            String str2 = str + "->";
            findPath(res, root.right, str2);
        }
    }
}
