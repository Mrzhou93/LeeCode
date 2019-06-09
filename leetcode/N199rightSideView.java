package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */

public class N199rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        level(ans, root, 0);

        return ans;
    }

    public void level(List<Integer> ans, TreeNode root, int depth){
        if (root == null)
            return;

        if (depth == ans.size())
            ans.add(root.val);

        level(ans, root.right, depth + 1);
        level(ans, root.left, depth + 1);
    }
}
