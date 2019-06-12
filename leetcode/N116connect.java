package leetcode;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */

class TreeNode1 {
    public int val;
    public TreeNode1 left;
    public TreeNode1 right;
    public TreeNode1 next;

    public TreeNode1() {}

    public TreeNode1(int _val, TreeNode1 _left, TreeNode1 _right, TreeNode1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class N116connect {

    public TreeNode1 connect(TreeNode1 root) {
        if (root==null)
            return null;

        if (root.left != null && root.right != null){
            root.left.next = root.right;
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }

}
