package src;

import java.util.LinkedList;
import java.util.List;

class N145postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        post(root, res);
        return res;
    }

    private void post(TreeNode root, List<Integer> res){
        if (root!=null){
            post(root.left, res);
            post(root.right, res);
            res.add(root.val);
        }
    }
}
