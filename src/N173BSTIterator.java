package src;

import java.util.LinkedList;
import java.util.Queue;

class BSTIterator {

    Queue<Integer> vals = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        build(root);
    }

    private void build(TreeNode root){
        if (root != null) {
            build(root.left);
            this.vals.add(root.val);
            build(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext())
            return -1;
        return vals.remove();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !vals.isEmpty();
    }
}

