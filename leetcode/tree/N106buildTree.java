package leetcode.tree;

import leetcode.TreeNode;

class N106buildTree {
    public leetcode.TreeNode buildTree(int[] inorder, int[] postorder) {
        return builder(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private leetcode.TreeNode builder(int[] inorder, int[] postorder, int inStart, int inEnd,
                                      int postEnd){

        if (inStart > inEnd)
            return null;

        int curVal = postorder[postEnd];
        leetcode.TreeNode tree = new leetcode.TreeNode(curVal);

        int markerIn;  //markerIn 找根节点

        for (markerIn = inStart; markerIn < inEnd; markerIn++){
            if (inorder[markerIn] == curVal)
                break;
        }

        leetcode.TreeNode left = builder(inorder, postorder, inStart, markerIn-1,
                 postEnd - (inEnd - markerIn) - 1);

        TreeNode right = builder(inorder, postorder, markerIn + 1, inEnd, postEnd-1);
        tree.left = left;
        tree.right = right;
        return tree;
    }
}
