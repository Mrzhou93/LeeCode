package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class N230kthSmallest {

    public int N230kthSmallest1(TreeNode root, int k) {   // 先序遍历的办法

        Queue<Integer> queue = new LinkedList<>();
        inOrder(root, queue);

        for (int i = 0; i < k -1; i++){
            queue.remove();
        }

        return queue.poll();
    }

    private void inOrder(TreeNode root, Queue<Integer> queue){
        if (root!=null){
            inOrder(root.left, queue);
            queue.add(root.val);
            inOrder(root.right, queue);
        }
    }

    public int kthSmallest(TreeNode root, int k){
        int leftCount = count(root.left);

        if (k == leftCount + 1)
            return root.val;

        else if (k < leftCount + 1)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - leftCount - 1);
    }

    private int count(TreeNode root){
        if (root == null)
            return 0;

        return count(root.left) + count(root.right) + 1;
    }
}
