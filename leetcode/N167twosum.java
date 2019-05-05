package leetcode;

import java.util.HashMap;
import java.util.Map;

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