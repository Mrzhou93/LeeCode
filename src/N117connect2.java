package src;

class N117connect2 {
    public TreeNode1 connect(TreeNode1 root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode1 next = getNextNode(root.next);

        if (root.left != null && root.right !=null){
            root.left.next = root.right;
            root.right.next = next;
        }

        if (root.left != null && root.right == null)
            root.left.next = next;
        if (root.right != null && root.left == null)
            root.right.next = next;

        connect(root.right);
        connect(root.left);


        return root;
    }

    private TreeNode1 getNextNode(TreeNode1 root){
        while (root != null){
            if (root.left != null)
                return root.left;
            if (root.right != null)
                return root.right;
            root = root.next;
        }
        return null;
    }
}
