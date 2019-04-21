package leetcode;

import java.util.Arrays;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * */


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }


class N435eraseOverlapIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1)
            return 0;

        int res = 0;

        // 以start位置为主要，end位置为次排序
        Arrays.sort(intervals, (o1, o2) -> o1.start == o2.start? o1.end - o2.end: o1.start - o2.start);

        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start < end){
                res++;
                end = Math.min(intervals[i].end, end);      // 选重复距离中最小的
            }else {
                end = intervals[i].end;
            }
        }

        return res;
    }


    public static void main(String[] args){
        Interval[] arr = new Interval[4];

        arr[0] = new Interval(1, 2);
        arr[1] = new Interval(2, 3);
        arr[2] = new Interval(3, 4);
        arr[3] = new Interval(1, 3);

        N435eraseOverlapIntervals s = new N435eraseOverlapIntervals();
        System.out.println(s.eraseOverlapIntervals(arr));
    }

}
