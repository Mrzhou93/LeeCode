package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */


class N144preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();

        pre(root, res);
        return res;
    }

    private void pre(TreeNode root, List<Integer> res){
        if (root!=null){
            res.add(root.val);
            pre(root.left, res);
            pre(root.right, res);
        }
    }
}

