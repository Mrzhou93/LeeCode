//package src;
//
//class TreeNode1 {
//    public int val;
//    public TreeNode1 left;
//    public TreeNode1 right;
//    public TreeNode1 next;
//
//    public TreeNode1() {}
//
//    public TreeNode1(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}
//
//class Nconnect {
//
//    public TreeNode1 connect(TreeNode1 root) {
//        if (root==null)
//            return null;
//        if (root.left != null && root.right != null){
//            root.left.next = root.right;
//            if (root.next != null){
//                root.right.next = root.next.left;
//            }
//        }
//
//        connect(root.left);
//        connect(root.right);
//
//        return root;
//    }
//
//}
