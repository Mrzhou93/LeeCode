package leetcode;

class N236lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int l = p.val, b = q.val;       // l为比较小的那个，b为比较大的那个
        if (b < l){
            int temp = b;
            b = l;
            l = temp;
        }
        if (root.val > l && root.val > b)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < l && root.val < b)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
