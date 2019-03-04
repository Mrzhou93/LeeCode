package src;

class NmoveZeros {
    public void moveZeroes(int[] nums) {
        int k = 0;  // 记录0的个数

        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0){
                int tmp;
                nums[k++] = nums[i];
            }
        }

        while (k < nums.length){
            nums[k++] = 0;
        }
    }
}
