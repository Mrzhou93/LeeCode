package leetcode.ainterview.jd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），那么最多能将这些学生分成多少组？
 *
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 *
 * 第二行包含N个空格隔开的整数H1到HN，1≤Hi≤109。
 *
 * 输出
 * 输出能分成的最多组数。
 *
 *
 * 样例输入
 * 4
 * 2 1 3 2
 * 样例输出
 * 2
 */

public class JD1 {
    public int maxDiv(int[] nums){
        int ans = 0;
        int[] copy = nums.clone();
        Arrays.sort(copy);

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            map2.put(copy[i], map2.getOrDefault(copy[i], 0) + 1);
            if (map1.equals(map2)){
                ans++;
                map1 = new HashMap<>();
                map2 = new HashMap<>();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        JD1 s = new JD1();

        while (in.hasNextInt()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            System.out.println(s.maxDiv(nums));
        }
    }
}
