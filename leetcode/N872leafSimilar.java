package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *  
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 100 个结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N872leafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        List<Integer> list1 = new ArrayList<>();
        dfs(list1, root1);

        List<Integer> list2 = new ArrayList<>();
        dfs(list2, root2);


        return list1.equals(list2);
    }

    public void dfs(List<Integer> list, TreeNode root){
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            list.add(root.val);
        }

        dfs(list, root.left);
        dfs(list, root.right);
    }
}
