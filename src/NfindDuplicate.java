package src;

class NfindDuplicate {
    public int findDuplicate1(int[] nums) {
        if (nums == null)
            return -1;

        int i = 0, j = nums.length - 1;
        while (i < j){
            int mid = i + (j - i) / 2;
            int count = 0;
            for (int num: nums){
                if (num <= mid)
                    count++;
            }
            if (count <= mid)
                i = mid + 1;
            else
                j = mid;
        }
        return i;
    }

    public int findDuplicate(int[] nums){
        int fast = 0, slow = 0;

        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow)
                break;
        }

        fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast)
                break;
        }
        return slow;
    }


    public static void main(String[] args){
        int[] nums = {1, 3, 4, 2, 2};
        int[] nums1 = {3, 1, 3, 4, 2};
        NfindDuplicate s = new NfindDuplicate();
        System.out.println(s.findDuplicate(nums));
        System.out.println("==================");
        System.out.println(s.findDuplicate(nums1));
    }
}
