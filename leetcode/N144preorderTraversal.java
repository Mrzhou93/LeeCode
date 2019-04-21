package leetcode;

import java.util.LinkedList;
import java.util.List;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


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

