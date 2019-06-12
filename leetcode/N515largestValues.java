package leetcode;

import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N515largestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return list;

        ((LinkedList<TreeNode>) queue).add(root);

        while (!queue.isEmpty()){

            int length = queue.size();

            int max = ((LinkedList<TreeNode>) queue).get(0).val;
            for (int i = 1; i < queue.size(); i++){
                if (max < ((LinkedList<TreeNode>) queue).get(i).val){
                    max = ((LinkedList<TreeNode>) queue).get(i).val;
                }
            }
            list.add(max);

            for (int i = 0; i < length; i++){
                TreeNode tmp = queue.peek();
                if (tmp.left != null)
                    ((LinkedList<TreeNode>) queue).add(tmp.left);
                if (tmp.right != null)
                    ((LinkedList<TreeNode>) queue).add(tmp.right);
                queue.poll();
            }
        }
        return list;
    }
}
