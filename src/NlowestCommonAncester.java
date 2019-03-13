//package src;
//
//class NlowestCommonAncester {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (isChild(root.left, p) && isChild(root.right, p))
//            return root;
//        if (isChild(root.right, p) && isChild(root.right, p))
//            return root;
//
//        return null;
//    }
//
//    private boolean isChild(TreeNode root, TreeNode p){
//        if (root == null)
//            return false;
//
//        if (root == p)
//            return true;
//        return isChild(root.left, p) || isChild(root.right, p);
//    }
//}
