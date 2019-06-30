package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class N94BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        return recursion(list, root);

    }

    private List recursion(List list, TreeNode root){
        if(root != null){
            recursion(list, root.left);
            list.add(root.val);
            recursion(list, root.right);
        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        TreeNode topNode = root;

        while(!stack.isEmpty() || topNode != null){

            if (topNode != null){
                stack.push(topNode);
                topNode = topNode.left;
            } else{
                topNode = stack.pop();
                list.add(topNode.val);
                topNode = topNode.right;
            }
        }
        return list;
    }
}