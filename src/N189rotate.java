package src;

class N189rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int t){
        while (s<t){
            int tmp = nums[s];
            nums[s++] = nums[t];
            nums[t--] = tmp;
        }
    }
}
