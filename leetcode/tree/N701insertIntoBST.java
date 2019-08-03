package leetcode.tree;

import leetcode.TreeNode;

class N701insertIntoBST {
    public leetcode.TreeNode insertIntoBST(leetcode.TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);

        return root;
    }
}
