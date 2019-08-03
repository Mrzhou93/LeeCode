package leetcode.tree;

import leetcode.TreeNode;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N449Codec {
    // Encodes a tree to a single string.
    public String serialize(leetcode.TreeNode root) {
        if (root == null)
            return "";

        String s = root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);

        return s;
    }

    // Decodes your encoded data to tree.
    public leetcode.TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] arr = data.split(",");
        return build(arr, 0, arr.length);
    }

    public leetcode.TreeNode build(String[] s, int start, int end){
        if (start == end)
            return null;
        leetcode.TreeNode root = new TreeNode(Integer.parseInt(s[start]));

        int i;
        for (i = start + 1; i < end; i++){
            if (Integer.parseInt(s[i]) > Integer.parseInt(s[start])){
                break;
            }
        }
        root.left = build(s, start + 1, i);
        root.right = build(s, i, end);

        return root;
    }
}
