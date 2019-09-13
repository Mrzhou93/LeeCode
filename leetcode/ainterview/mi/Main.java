package leetcode.ainterview.mi;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 小米之家购物
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 小米之家有很多米粉喜欢的产品，产品种类很多，价格也不同。比如某签字笔1元，某充电宝79元，某电池1元，某电视1999元等
 *
 * 假设库存不限，小明去小米之家买东西，要用光N元预算的钱，请问他最少能买几件产品？
 *
 * 输入
 * 第1行为产品种类数
 *
 * 接下来的每行为每种产品的价格
 *
 * 最后一行为预算金额
 *
 *
 * 输出
 * 能买到的最少的产品的件数，无法没有匹配的返回-1
 *
 *
 * 样例输入
 * 2
 * 500
 * 1
 * 1000
 * 样例输出
 * 2
 */

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
        if (prices == null || prices.length == 0) {
            return -1;
        }

        int ans = 0;
        Arrays.sort(prices);

        for (int i = prices.length - 1; i >= 0; i--) {
            if (budget == 0) {
                break;
            }

            if (prices[i] == 0) {
                break;
            }

            int nums = budget / prices[i];

            if (nums > 0){
                ans += nums;
                budget -= (prices[i] * nums);
            }
        }
        return ans != 0 && budget == 0? ans: -1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));
    }
}

