package src;

class NfindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        if (nums.length == 0)
            return -1;

        if (nums[0] > nums[1])
            return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        int i = 0, j = nums.length - 1;

        while (i < j){
            int mid = i + (j - i) / 2;
            if (mid > 0 && mid < nums.length - 1 &&
                    nums[mid] > nums[mid-1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if (nums[mid] > nums[mid - 1])
                i = mid + 1;
            else
                j = mid;
        }

        return -1;
    }


    public static void main(String[] args){
        NfindPeakElement s = new NfindPeakElement();

        int[] nums = {1,2,3,1};
        int[] nums1 = {2,1};

//        System.out.println(s.findPeakElement(nums));
        System.out.println(s.findPeakElement(nums1));
    }
}
