package leetcode.ainterview.jd;

import java.util.*;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 某校在积极推行无人监考制度，但是总有学生是不自觉的，如果将两个很熟的异性朋友放在同一个考场里，他们就会交流甚至作弊。因此一个考场中不能允许两个很熟的异性朋友存在，学校希望通过搬出一部分学生的方法来改善这一问题。
 *
 * 但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，请你输出搬出教室人数最少，且字典序最小的方案。
 *
 * 输入
 *   输入第一行有两个整数n和m，分别表示有n个男生和n个女生，有m个朋友关系。
 *
 * (1<=n<=500,1<=m<=100000)
 *
 *   接下来m行，每行有两个整数，x和y，表示第x号男生和第y号女生是朋友。男生的编号均为[1,n]，女生的编号为[n+1,2n]。
 *
 * 输出
 * 输出第一行包含一个整数a，表示最少需要搬出教室的人数。
 *
 * 输出第二行有a个整数，即a个需要搬出教室的人的编号，要求人数最少，且字典序最小。
 *
 *
 * 样例输入
 * 2 2
 * 3 1
 * 1 4
 * 样例输出
 * 1
 * 1
 */

public class JD2 {
    public void solution(int n, int[][] nums){
        int[] toBoy = new int[n * 2];
        int[] toGirl = new int[n * 2];

        for (int i = 0; i < n * 2; i++){
            toBoy[i] = i;
            toGirl[i] = i;
        }

        for (int[] num: nums){
            int boy = num[0] - 1;
            int girl = num[1] - 1;
            toBoy[girl] = boy;
            toGirl[boy] = girl;
        }

        List<Integer> boySet = new ArrayList<>();
        List<Integer> girlSet = new ArrayList<>();
        for (int i = 0; i < n * 2; i++){
            if (toBoy[i] != i){
                boySet.add(i);
            }
            if (toGirl[i] != i){
                girlSet.add(i);
            }
        }


        if (boySet.size() < girlSet.size()) {
            System.out.println(boySet.size());
            for (int i = 0; i < boySet.size(); i++) {
                System.out.print(((List<Integer>) boySet).get(i) + 1);
            }
        } else {
            System.out.println(girlSet.size());
            for (int i = 0; i < girlSet.size(); i++) {
                System.out.print(((List<Integer>) girlSet).get(i) + 1);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        JD2 s = new JD2();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] nums = new int[m][2];
            for (int i = 0; i < m; i++){
                nums[i][0] = in.nextInt();
                nums[i][1] = in.nextInt();
            }
            s.solution(n, nums);
        }
//        s.solution(2, new int[][]{{1, 3}, {1, 4}});
//        s.solution(2, new int[][]{{1, 3}, {2, 3}});
    }
}
