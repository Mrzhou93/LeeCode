package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class N102lebelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        ((LinkedList<TreeNode>) queue).add(root);

        while(!queue.isEmpty()){
             List<Integer> level = new ArrayList<>();
             int k = queue.size();
             while(k>0){
                 TreeNode cur = queue.poll();
                 level.add(cur.val);
                 if (cur.left != null){
                     ((LinkedList<TreeNode>) queue).add(cur.left);
                 }
                 if (cur.right != null){
                     ((LinkedList<TreeNode>) queue).add(cur.right);
                 }
                 k--;
             }
             res.add(level);
        }
        return res;
    }
}
