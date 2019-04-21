package leetcode;

import java.util.Arrays;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 *
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * */

class N621leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int kind = 0;
        int[] cal = new int[26];

        for (char task: tasks){
            if (cal[task - 'A'] == 0)
                kind++;
            cal[task - 'A']++;
        }

        int[] taskTimes = new int[kind];

        int k = 0;
        for (int i = 0; i < cal.length; i++){
            if (cal[i] != 0) {
                taskTimes[k] = cal[i];
                k++;
            }
        }

        Arrays.sort(taskTimes);  // 按照词频排序，升序

        int maxCount = 0;
        for (int i = taskTimes.length - 1; i >= 0; i--){
            if (taskTimes[i] != taskTimes[taskTimes.length - 1]){
                break;
            }
            maxCount++;
        }

        System.out.print("[");
        for (int i = 0; i < taskTimes.length; i++)
            System.out.print(taskTimes[i]+",");
        System.out.println("]");

        return Math.max((taskTimes[taskTimes.length - 1] - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String [] args){
        N621leastInterval s = new N621leastInterval();

        char[] chars = {'A','A','B','B','B'};

        System.out.println(s.leastInterval(chars, 2));
    }
}
