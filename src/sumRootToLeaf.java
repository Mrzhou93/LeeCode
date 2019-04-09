package src;

class sumRootToLeaf {

    private int Mod = 10^9 + 7;
    private int result;

    public int sumRootToLeaf(TreeNode root) {
        this.result = 0;
        dfs(root, 0);
        return this.result;
    }

    private void dfs(TreeNode root, int val){
        if (root == null)
            return;

        val = (val * 2 + root.val) % Mod;

        if (root.left == null && root.right == null)
            result = (result + val) % Mod;

        dfs(root.left, val);
        dfs(root.right, val);
    }
}
