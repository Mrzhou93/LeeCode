package leetcode;

class N485findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 0;
        int max = 0;

        for (int i = 0; i< nums.length; i++){
            if (nums[i]==1) {
                k++;

                if (i + 1 == nums.length && k > max) {
                    max = k;
                }
            }
            else {
                if (k > max) {
                    max = k;
                }
                k = 0;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {1};
        int[] nums1 = {1,0,1,1,0,1};
        int[] nums2 = {0,1};

        N485findMaxConsecutiveOnes s = new N485findMaxConsecutiveOnes();
        System.out.println(s.findMaxConsecutiveOnes(nums));
        System.out.println(s.findMaxConsecutiveOnes(nums1));
        System.out.println(s.findMaxConsecutiveOnes(nums2));
    }
}
