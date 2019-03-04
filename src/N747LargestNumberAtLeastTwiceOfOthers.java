package src;

class N747LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        // 找出最大值和次大值
        int max = -1, maxIndex = -1, secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? maxIndex : -1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,2,3};
        int[] nums1 = {0,0,0,1};
        int[] nums2 = {1};
        int[] nums3 = {1, 0};
        int[] nums4 = {0,0,3,2};
        N747LargestNumberAtLeastTwiceOfOthers s = new N747LargestNumberAtLeastTwiceOfOthers();
        System.out.println(s.dominantIndex(nums));  // -1
        System.out.println(s.dominantIndex(nums1)); // 3
        System.out.println(s.dominantIndex(nums2)); // 0
        System.out.println(s.dominantIndex(nums3)); // 0
        System.out.println(s.dominantIndex(nums4)); //-1
    }

}
