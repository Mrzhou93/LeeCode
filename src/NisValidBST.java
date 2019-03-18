package src;

class NisValidBST {

    int maxValue = - Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (!isValidBST(root.left)){
            if (maxValue < root.val){
                maxValue = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
