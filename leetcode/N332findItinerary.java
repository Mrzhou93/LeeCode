package leetcode;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与
 * ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class N332findItinerary {
    private List<String> ans = new LinkedList<>();
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(from, pq);
            }
            map.get(from).add(to);
        }

        System.out.println(map);

        dfs("JFK");
        return ans;
    }

    public void dfs(String from){
        PriorityQueue<String> pq = map.get(from);

        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        ((LinkedList<String>) ans).addFirst(from);  // 加载Array的最前面
    }

    public static void main(String[] args){
        N332findItinerary s = new N332findItinerary();

        List<List<String>> in = new ArrayList<>();
        List<String> f1 = new ArrayList<String>(); f1.add("JFK"); f1.add("SFO");
        List<String> f2 = new ArrayList<String>(); f2.add("JFK"); f2.add("ATL");
        List<String> f3 = new ArrayList<String>(); f3.add("SFO"); f3.add("ATL");
        List<String> f4 = new ArrayList<String>(); f4.add("ATL"); f4.add("JFK");
        List<String> f5 = new ArrayList<String>(); f5.add("ATL"); f5.add("SFO");

        in.add(f1);
        in.add(f2);
        in.add(f3);
        in.add(f4);
        in.add(f5);

        System.out.println(s.findItinerary(in));
    }

}
