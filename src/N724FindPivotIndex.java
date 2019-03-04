package src;

class N724FindPivotIndex {
    public int pivotIndex(int[] nums) {

        int leftSum = 0;
        int totalSum = 0;
        for (int num: nums)
            totalSum += num;

        for (int i=0; i<nums.length; i++){
            if (totalSum - nums[i] == leftSum * 2)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};
        int[] nums1 = {-1,-1,-1,0,1,1};

        N724FindPivotIndex s = new N724FindPivotIndex();

        System.out.println(s.pivotIndex(nums));
        System.out.println(s.pivotIndex(nums1));
    }
}
