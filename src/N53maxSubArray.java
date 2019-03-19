package src;

class NmaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int res = 0;
        for(int i=0; i < nums.length; i++){
            res = Math.max(nums[i], res+nums[i]);
            max = Math.max(res, max);
        }
        return max;
    }

    public int maxSubArray1(int[] nums){
        int sum = 0;
        int max = nums[0];
        for (int num:nums){
            if (num>=0)
                sum += num;
            else
                sum = num;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        NmaxSubArray s = new NmaxSubArray();
        System.out.println(s.maxSubArray(num));
    }
}
