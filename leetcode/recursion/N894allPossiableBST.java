package leetcode.recursion;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：7
 * 输出：[
 * [0,0,0,null,null,0,0,null,null,0,0],
 * [0,0,0,null,null,0,0,0,0],
 * [0,0,0,0,0,0,0],
 * [0,0,0,0,0,null,null,null,null,0,0],
 * [0,0,0,0,0,null,null,0,0]
 * ]
 *
 * 解释：
 *
 * 提示：
 *
 * 1 <= N <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N894allPossiableBST {

    public List<TreeNode> allPossibleFBT(int N) {
        if (N <= 0 || N % 2 == 0)
            return new ArrayList<>();

        List<TreeNode> ans = new ArrayList<>();

        if (N == 1){
            ans.add(new TreeNode(0));
            return ans;
        }

        for (int i = 1; i < N; i+=2){
            List<TreeNode> leftSubTree = allPossibleFBT(i);
            List<TreeNode> rightSubTree = allPossibleFBT(N - i - 1);
            for (TreeNode l: leftSubTree){
                for (TreeNode r: rightSubTree) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N894allPossiableBST s = new N894allPossiableBST();

        System.out.println(s.allPossibleFBT(7));
    }
}
