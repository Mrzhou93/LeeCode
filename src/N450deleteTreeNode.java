package src;

class N450deleteTreeNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val > key)
            root.left = deleteNode(root.left, key);

        else if (root.val < key)
            root.right = deleteNode(root.right, key);

        // 当key值与root的值相同，即删除当前的root节点时。首先检查一下该节点有没有左右孩子
        // 存在左右孩子节点时
        else if (root.left !=null && root.right != null) {
            root.val = findMin(root.right).val;      // 找出左孩子的最小值，作为删除的节点的值
            root.right = deleteNode(root.right, root.val);
        }
        // 如果不存在，或者存在一个孩子节点，此时删除此节点即可
        else {
            root = (root.left != null) ? root.left: root.right;
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        if (root != null){
            while(root.left != null){
                root = root.left;
            }
        }
        return root;
    }
}
