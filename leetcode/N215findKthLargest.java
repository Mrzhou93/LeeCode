package leetcode;

// https://www.itcodemonkey.com/article/12641.html

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

class N215findKthLargest {          // 分治法求解 时间复杂度O(n)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for (int num: nums){
            if (q.size() < k){
                q.offer(num);
            }else if (q.size() >= k && q.peek() < num){
                q.poll();
                q.offer(num);
            }
        }

        return q.peek();
    }

    public int findKthLargest1(int[] nums, int k) {
        return find(nums, 0, nums.length-1, k);
    }

    private int find(int[] nums, int s, int t, int k){
        int temp = nums[s];
        int i = s;
        int j = t;

        while (i < j){
            while (i < j && nums[j] <= temp)
                j--;
            if (i < j){
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] > temp)
                i++;
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }

        if (i == k - 1)
            return temp;
        else if (j < k - 1)
            return find(nums, j + 1, t, k);
        else
            return find(nums, s,j-1, k);
    }

    public static void main(String[] args){
        N215findKthLargest s = new N215findKthLargest();

        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
