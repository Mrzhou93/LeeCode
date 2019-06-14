package leetcode;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 : 
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val,List<Node1> _children) {
        val = _val;
        children = _children;
    }
}

public class N559maxDepth {
    public int maxDepth(Node1 root) {
        if (root == null)
            return 0;

        int max = 0;
        int[] depth = new int[root.children.size()];

        for (int i = 0; i < root.children.size(); i++){
            depth[i] = maxDepth(root.children.get(i)) + 1;
            if (max < depth[i]){
                max = depth[i];
            }
        }

        return max + 1;
    }
}

