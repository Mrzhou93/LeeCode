package src;

class NbuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode builder(int[] inorder, int[] postorder,int inStart, int inEnd,
                             int postEnd){

        if (inStart > inEnd)
            return null;

        int curVal = postorder[postEnd];
        TreeNode tree = new TreeNode(curVal);

        int markerIn;  //markerIn 找根节点

        for (markerIn = inStart; markerIn < inEnd; markerIn++){
            if (inorder[markerIn] == curVal)
                break;
        }

        TreeNode left = builder(inorder, postorder, inStart, markerIn-1,
                 postEnd - (inEnd - markerIn) - 1);

        TreeNode right = builder(inorder, postorder, markerIn + 1, inEnd, postEnd-1);
        tree.left = left;
        tree.right = right;
        return tree;
    }
}
