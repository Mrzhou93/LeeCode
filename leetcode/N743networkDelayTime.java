package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有 N 个网络节点，标记为 1 到 N。
 *
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点，
 * w 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，
 * 返回 -1。
 *
 * 注意:
 *
 * N 的范围在 [1, 100] 之间。
 * K 的范围在 [1, N] 之间。
 * times 的长度在 [1, 6000] 之间。
 * 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N743networkDelayTime {

    private static int INF = 101;

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N];
        int[][] graph = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < times.length; i++){
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

//        System.out.println(Arrays.deepToString(graph));

        for (int i = 0; i < N; i++){
            dist[i] = INF;
        }
        dist[K - 1] = 0;

        pq.add(K - 1);
        while (!pq.isEmpty()){
            int from = pq.poll();
            for (int to = 0; to < N; to++){
                if (graph[from][to] != 0 && dist[from] + graph[from][to] < dist[to]){
                    dist[to] = dist[from] + graph[from][to];
                    pq.add(to);
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        int ans = 0;
        for(int i = 0; i < N; i++){
            if (i != K)
                ans = Math.max(ans, dist[i]);
        }

        return ans == INF? -1: ans;
    }

    public static void main(String[] args){
        N743networkDelayTime s = new N743networkDelayTime();

        System.out.println(s.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(s.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
