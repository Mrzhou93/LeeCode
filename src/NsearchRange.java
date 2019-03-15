package src;

import java.util.ArrayList;
import java.util.LinkedList;

class NsearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums.length == 0) {
            return result;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                break;
            else if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
        }
//        System.out.println(start + (end - start) / 2);
//        System.out.println(start);
//        System.out.println(end);

        if (nums[end] == target)
            System.out.println(end);
            result[0] = end;
        if (nums[start] == target)
            System.out.println(start);
            result[0] = start;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                break;
            else if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        if (nums[right] == target)
            System.out.println(left);
            result[1] = right;

        return result;
    }

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int[] nums1 = {1, 2, 3};

        NsearchRange s = new NsearchRange();

        System.out.println(s.searchRange(nums, 8));
    }
}
