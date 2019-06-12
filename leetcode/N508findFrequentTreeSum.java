package leetcode;

import java.util.*;

/**
 * 给出二叉树的根，找出出现次数最多的子树元素和。
 * 一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 *
 * 示例 1
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2
 * 输入:
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *  
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N508findFrequentTreeSum {
    private int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();

        find(root,map);

        List<Integer> res = new ArrayList<>();

        for(Integer num : map.keySet()){
            if(map.get(num) == max){
                res.add(num);
            }
        }

        int[] array = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            array[i] = res.get(i);
        }
        return array;
    }

    private int find(TreeNode root,Map<Integer,Integer> map){
        if(root == null)
            return 0;
        int left = find(root.left,map);
        int right = find(root.right,map);
        int key = left + root.val + right;

        map.put(key, map.getOrDefault(key, 1) + 1);

        max = Math.max(max, map.get(key));
        return key;
    }
}
