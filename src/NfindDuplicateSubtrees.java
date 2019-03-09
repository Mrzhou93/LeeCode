//package src;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//class NfindDuplicateSubtrees {
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        return isDuplicate(root, root);
//    }
//
//    private boolean isDuplicate(TreeNode t1, TreeNode t2){
//        if (t1.val != t2.val)
//            return false;
//        if (t1.right == t2.left && t1.left == t2.right && t1.val == t2.val)
//            return true;
//    }
//}