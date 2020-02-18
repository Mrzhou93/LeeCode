package leetcode.ainterview.baidu;


/**
 * 石头剪刀布
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 西西打算和一头小猪进行N轮石头剪刀布，初始时双方的分数都为0，对每一轮而言，如果不是平局则胜者得1分，败者扣1分。
 * 小猪告诉西西它会在其中的M轮出石头，这意味着它会在剩下的N-M轮出剪刀（因为小猪不会出布）。西西想让自己的分数尽可能高，
 * 那么在西西足够聪明的情况下，他的分数至少是多少？
 *
 * 输入
 * 输入两个空格隔开的整数N和M，0≤M≤N≤109
 *
 * 输出
 * 输出在西西足够聪明的情况下，他的分数可能的最小值
 *
 *
 * 样例输入
 * 2 1
 * 样例输出
 * 1
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */



import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public int max(int N, int M){
        if (N == M){
            return N;
        }

        if (M == 1){
            return N - 1;
        }


        int[] dp = new int[N + 1];

        dp[1] = N - 1;

        for(int i = 2; i <= N; i++){
            if(i != M + 1) {
                dp[i] = dp[i - 1] - 1;
            }else  {
                dp[i] = N;
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[M];
    }

    public static void main(String[] args) {
        Main s = new Main();
        System.out.println(s.max(4 , 3));
        Scanner sc = new Scanner(System.in);
//        System.out.println(s.max(4 , 3));
        while (sc.hasNextInt()){
            int N = sc.nextInt();
            int M = sc.nextInt();
        System.out.println(s.max(N, M));
        }
    }
}
