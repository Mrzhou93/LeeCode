package leetcode;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */

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

        if (root.left == null && root.right != null)
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
