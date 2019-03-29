package src;

// https://www.itcodemonkey.com/article/12641.html

class N215findKthLargest {          // 分治法求解 时间复杂度O(n)
    public int findKthLargest(int[] nums, int k) {
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
}
