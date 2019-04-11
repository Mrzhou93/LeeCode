package src;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * */

public class N309maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int[] dp = new int[prices.length + 1];

        for (int i = 2; i <= prices.length; i++){    // i天的时候卖
            dp[i] = dp[i - 1];
            for (int j = i - 1; j > 0; j--){        // j天的时候买
                if (prices[i - 1] > prices[j - 1]){
                    int tmp = (j > 2)? dp[j - 2]: 0;
                    dp[i] = Math.max(dp[i], tmp + prices[i - 1] - prices[j - 1]);
                }
            }
        }

        return dp[prices.length];
    }

    public static void main(String [] args){
        int[] prices = {1, 2, 3, 0, 2};             // 3
        int[] prices1 = {7, 1, 5, 3, 6, 4};         // 5
        int[] prices2 = {1, 5};                     // 4

        N309maxProfit s = new N309maxProfit();
        System.out.println(s.maxProfit(prices));
        System.out.println(s.maxProfit(prices1));
        System.out.println(s.maxProfit(prices2));

    }
}
