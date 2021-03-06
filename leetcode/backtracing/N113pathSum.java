package leetcode.backtracing;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

public class N113pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, sum, ans, path);

        return ans;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> path) {
        if (root == null)
            return;

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(path)); // deep copy
        } else {
            dfs(root.left, sum - root.val, ans, path);
            dfs(root.right, sum - root.val, ans, path);
        }
        path.remove(path.size() - 1);
    }
}
