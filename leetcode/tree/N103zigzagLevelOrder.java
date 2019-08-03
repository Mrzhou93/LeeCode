package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，
 * 以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class N103zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stacklr = new Stack<>();
        Stack<TreeNode> stackrl = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        boolean lr = true;

        stacklr.push(root);

        while (!stacklr.isEmpty() || !stackrl.isEmpty()){
            List<Integer> ll = new ArrayList<>();

            if (lr){
                while (!stacklr.isEmpty()){
                    TreeNode cur = stacklr.pop();
                    ll.add(cur.val);

                    if (cur.left != null)
                        stackrl.push(cur.left);
                    if (cur.right!=null)
                        stackrl.push(cur.right);
                }
            } else {
                while(!stackrl.isEmpty()){
                    TreeNode cur = stackrl.pop();
                    ll.add(cur.val);

                    if (cur.right != null)
                        stacklr.push(cur.right);
                    if (cur.left != null)
                        stacklr.push(cur.left);
                }
            }
            lr = !lr;
            res.add(ll);
        }
        return res;
    }
}
