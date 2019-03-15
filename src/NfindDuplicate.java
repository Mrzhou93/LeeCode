package src;

class NfindDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i< nums.length; i++){

            System.out.println(nums[i]);

            int index = Find(nums, nums[i]);
            System.out.println("    "+index);

            if (index != -1 && i != index)
                return nums[i];
        }
        return -1;
    }

    private int Find(int[] nums, int target){
        int i= 0, j = nums.length - 1;
        while (i < j){
            int mid = i + (j - i) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 3, 4, 2, 2};
        int[] nums1 = {3, 1, 3, 4, 2};
        NfindDuplicate s = new NfindDuplicate();
        System.out.println(s.findDuplicate(nums));
        System.out.println(s.findDuplicate(nums1));
    }
}
