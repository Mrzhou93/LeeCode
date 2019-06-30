package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1103. 二叉树寻路  显示英文描述
 * 用户通过次数 9
 * 用户尝试次数 9
 * 通过次数 9
 * 提交次数 11
 * 题目难度 Easy
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 *
 * 提示：
 *
 * 1 <= label <= 10^6
 */

public class N1103pathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        int size = 1;
        int depth = 0;
        while (size <= label){
            size *= 2;
            depth++;
        }

        int[] path = new int[size - 1];

        for (int i = 1; i <=size - 1; i++){
            path[i - 1] = i;
        }

        System.out.println(Arrays.toString(path));

        int level = 0;
        int from = 1;

        while (level < depth){

            if (level % 2 == 1){

//                System.out.println("from=" + from);
//                System.out.println("level=" + level);

                swap(path, from - 1, (from - 1) * 2 );
            }
            level++;
            from *= 2;
        }

        int index = -1;
        for (int i = 0; i < path.length; i++){
            if (path[i] == label)
                index = i;
        }

        System.out.println(index);

        List<Integer> ans = new LinkedList<>();

        while(index >= 0){
            ans.add(0, path[index]);
            index = ((index + 1) / 2) - 1;
        }

//        System.out.println(ans);

        return ans;
    }

    public void swap(int[] path, int x, int y){
        while (x < y){
            int tmp = path[x];
            path[x] = path[y];
            path[y] = tmp;
            x++;
            y--;
        }
    }

    public static void main(String[] args){
        N1103pathInZigZagTree  s = new N1103pathInZigZagTree();

        System.out.println(s.pathInZigZagTree(14));
        System.out.println(s.pathInZigZagTree(16));
        System.out.println(s.pathInZigZagTree(26));
    }
}
