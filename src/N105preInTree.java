package src;

class NpreInTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode builder(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (inStart > inEnd)
            return null;

        int culVal = preorder[preStart];
        TreeNode tree = new TreeNode(culVal);

        int marker;
        for (marker = inStart; marker < inEnd; marker++){
            if (inorder[marker] == culVal)
                break;
        }

        TreeNode left = builder(preorder, inorder, preStart + 1,
                inStart, marker - 1);
        TreeNode right = builder(preorder, inorder, preStart + marker - inStart + 1,
                marker + 1, inEnd);
        tree.left = left;
        tree.right = right;
        return tree;
    }
}
