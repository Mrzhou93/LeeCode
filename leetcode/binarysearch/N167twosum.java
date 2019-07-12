package leetcode.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N167twosum {
    public int[] twoSum(int[] numbers, int target){     // nlog(n)
        int[] res = new int[2];

        for (int i = 0; i< numbers.length; i++){
            int another = target - numbers[i];
            int index = halffind(numbers, another);
            if (index != -1 && i != index){
                if (i < index) {
                    res[0] = i + 1;
                    res[1] = index + 1;
                }else {
                    res[1] = i + 1;
                    res[0] = index + 1;
                }
            }
        }
        return res;
    }

    private int halffind(int[] numbers, int target){
        int i = 0, j = numbers.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (numbers[mid] == target)
                return mid;
            else if (numbers[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++){
            int diff = target - numbers[i];
            if (map.containsKey(diff) && i != map.get(diff))
                return new int[] {i, map.get(diff)};
        }
        return null;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;

        while(i < j && numbers[i] + numbers[j] != target){
            if (numbers[i] + numbers[j] == target)
                break;
            else if (numbers[i] + numbers[j] < target)
                j--;
            else
                i++;
        }
        result[0] = i+1;
        result[1] = j+1;
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int[] nums1 = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,
                180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,
                368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,
                506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,
                755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,
                920,926,927,930,933,957,981,997}; // 542 {24, 32}

        int[] nums2 = {0, 0, 3, 4};

        N167twosum s = new N167twosum();
        System.out.println(s.twoSum(nums, 9)[0]);
        System.out.println(s.twoSum(nums, 9)[1]);

        System.out.println(s.twoSum(nums1, 542)[0]);
        System.out.println(s.twoSum(nums1, 542)[1]);

        System.out.println(s.twoSum(nums2, 0)[0]);
        System.out.println(s.twoSum(nums2, 0)[1]);
    }
}
