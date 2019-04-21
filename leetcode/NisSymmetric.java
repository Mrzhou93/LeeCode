package leetcode;

class NisSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root== null)
            return false;

        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1.right == t2.left && t1.left == t2.right && t1.val == t2.val)
            return true;
        return false;
    }
}
