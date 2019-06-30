package leetcode.topsort;

import java.util.*;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，
 * 在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，
 * 写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边，
 * [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 * 示例 2:
 *
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * 输出: [3, 4]
 * 说明:
 *
 * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，
 * 一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N310findMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        int[] visited = new int[edges.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 0; i < n; i++){
            if (degree[i] == 1){
                queue.add(i);
            }
        }

        while (n > 2){
            int queueSize = queue.size();
            n -= queueSize;

            for (int i = 0; i < queueSize; i++){
                Integer num = queue.remove();
                degree[num] = -1;
                for (int j = 0; j < edges.length; j++){
                    if (visited[j] == 0){
                        if (edges[j][0] == num){
                            degree[edges[j][1]]--;
                        } else if (edges[j][1] == num){
                            degree[edges[j][0]]--;
                        }
                        visited[j]--;
                    }
                }
            }

            for (int i = 0; i < n; i++){
                if (degree[i] == 1){
                    queue.add(i);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < degree.length; i++){
            if (degree[i] != -1)
                ans.add(i);
        }
//        System.out.println("ans" + ans);
        return ans;
    }

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        int[] branch=new int[n];
        for(int i=0;i<n;i++)
            branch[i]=-1;  //代表结点i的度初始为-1
        for(int i=0;i<edges.length;i++){
            branch[edges[i][0]]++;
            branch[edges[i][1]]++;
        }
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(branch[i]>0){   //如果结点i的度超过2，则加入列表，并把该结点的度重调为-1（为下次循环准备）
                list.add(i);
                branch[i]=-1;
            }else
                branch[i]=-n;  //否则放弃该结点
        }if(n==1)list.add(0);
        if(n==2){list.add(0);list.add(1);}   //两种特殊情况的处理（只有一个或两个顶点）
        while(list.size()>2){
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==-1)continue;   //优化，上次被淘汰的边不可能出现在这次合格品中
                if(list.contains(edges[i][0])&&list.contains(edges[i][1])){
                    branch[edges[i][0]]++;
                    branch[edges[i][1]]++;
                }else{
                    edges[i][0]=-1;    //淘汰边
                }
            }List<Integer> oldList=list;
            list=new LinkedList<>();
            for(int i=0;i<oldList.size();i++){
                if(branch[oldList.get(i)]>0){     //优化，不在上次列表中的元素不可能出现在新元素中
                    list.add(oldList.get(i));
                    branch[oldList.get(i)]=-1;
                }else
                    branch[oldList.get(i)]=-n;
            }
        }
        return list;
    }


    public static void main(String[] args){
        N310findMinHeightTrees s = new N310findMinHeightTrees();
//        System.out.println(s.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3},
//                {2, 3}, {4, 3}, {5, 4}}));
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}
                }));
    }
}
