package leetcode;

import java.util.Arrays;

/**
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 *
 * 提示：
 *
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * */

public class N1029twoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;

        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] < o2[0] - o2[1]? 1: -1);

        System.out.println(Arrays.deepToString(costs));
//        for (int i = 0; i < costs.length; i++)
//            System.out.println("["+costs[i][0]+","+costs[i][1]+"]");

        int mid = costs.length / 2;

        for (int i = 0; i < mid; i++){
            res += costs[i][1];
            res += costs[mid + i][0];
        }

//        System.out.println(Arrays.deepToString(costs));

        return res;
    }

    public static void main(String[] args){
        N1029twoCitySchedCost s = new N1029twoCitySchedCost();

        int[][] num = {{10, 20},{30, 200},{400, 50},{30, 20}};
        int[][] num2 = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        int[][] num1 = {
                {803,60},{709,262},{636,484},{280,517},{570,276},{669,128},{54,98},{646,501}, {174,449},
                {99,369},{579,119},{295,764},{657,13},{56,107},{66,530},{602,973},{212,304}, {589,895},
                {990,94},{331,440},{55,556},{267,149},{319,442},{49,254},{412,657},{899,103}, {79,352},
                {877,184},{300,944},{702,302},{478,249},{321,352},{912,475},{45,666},{37,78},{950,845}};

        System.out.println(s.twoCitySchedCost(num));
//        System.out.println(num1.length);
        System.out.println(s.twoCitySchedCost(num1));
//        System.out.println(s.twoCitySchedCost(num2));
    }
}
