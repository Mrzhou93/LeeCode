package src;


class N33search {
    public int search(int[] nums, int target) {
        return searching(nums, 0, nums.length -1, target);
    }

    private int searching(int[] nums, int start, int end, int target){

        if (start <= end){
            int mid  = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]){                                   // 前半部分有序
                if (nums[start] <= target && target < nums[mid])            // target在无序部分
                    return searching(nums, start, mid - 1, target);
                else
                    return searching(nums, mid + 1, end, target);
            } else {                                                        // 后半部分有序
                if (nums[mid] < target && target <= nums[end])              // target在有序部分
                    return searching(nums, mid + 1, end, target);
                else
                    return searching(nums, start, mid - 1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        N33search s = new N33search();
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums1 = {1, 3};
        int[] nums2 = {3, 1};

        System.out.println(s.search(nums, 0));      // 4
        System.out.println(s.search(nums1, 3));     // 1
        System.out.println(s.search(nums2, 1));     // 1
    }
}
