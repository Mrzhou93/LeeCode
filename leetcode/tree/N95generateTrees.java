package leetcode.tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */

public class N95generateTrees {
    public List<leetcode.TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<>();

        return generateTrees(1, n);
    }

    public List<leetcode.TreeNode> generateTrees(int start, int end){
        List<leetcode.TreeNode> res = new ArrayList<>();

        if (start > end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++){
            List<leetcode.TreeNode> leftTree = generateTrees(start, i - 1);
            List<leetcode.TreeNode> rightTree = generateTrees(i + 1, end);
            for (leetcode.TreeNode left: leftTree){
                for (leetcode.TreeNode right: rightTree){
                    leetcode.TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
