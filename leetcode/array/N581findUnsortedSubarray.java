package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N581findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int begin = 0, end = len - 1;
        while(begin < end) {
            int flag = 1;
            if (nums[begin] == tmp[begin]) {
                begin++;
                flag = 0;
            }

            if (nums[end] == tmp[end]) {
                end--;
                flag = 0;
            }
            if (flag == 1) {
                break;
            }
        }
        return end - begin>0? end - begin + 1: 0;
    }

    public static void main(String[] args) {
        N581findUnsortedSubarray s = new N581findUnsortedSubarray();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
