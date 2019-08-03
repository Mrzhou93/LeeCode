package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */

public class N501findMode {
    List<Integer> list = new ArrayList<>();
    leetcode.TreeNode pre;
    int max = 0;
    int cur = 1;

    public int[] findMode(leetcode.TreeNode root) {
        if(root==null) {
            return new int[] {};
        }
        inorder(root);
        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            a[i]=list.get(i);
        }
        return a;
    }
    private void inorder(TreeNode root) {
        if(root==null) {
            return ;
        }
        inorder(root.left);
        if(pre!=null) {
            if(pre.val==root.val) {
                cur++;
            }
            else {
                cur=1;
            }
        }
        if(cur==max) {
            list.add(root.val);
        }
        if(cur>max) {
            list.clear();
            list.add(root.val);
            max=cur;
        }
        pre=root;
        inorder(root.right);
    }
}
