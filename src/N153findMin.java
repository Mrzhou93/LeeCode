package src;

class NfindMin {
    public int findMin(int[] nums) {

        return min(nums, 0, nums.length-1);
    }

    private int min(int[] nums, int start, int end){
        if (end == start)
            return nums[start];

        if (nums[start] < nums[end])
            return nums[start];

        if (end -start == 1)
            return nums[end];

        if (start < end){
            int mid = start + (end - start) / 2;

            if (nums[start] < nums[mid] && nums[mid] > nums[end]){       // 左边一半是有序的

                return min(nums, mid+ 1, end);
            }else if (nums[mid] < nums[end] && nums[start] > nums[mid]){    // 右边一半是有序的
                return min(nums, start, mid);
            }
        }
        return nums[end];
    }

    public static void main(String[] args){
        int[] num = {4,5,6,7,0,1,2};
        int[] num1 = {1};
        int[] num2 = {2, 1};
        int[] num3 = {3, 1, 2};

        NfindMin s = new NfindMin();

        System.out.println(s.findMin(num));
        System.out.println(s.findMin(num1));
        System.out.println(s.findMin(num2));
        System.out.println(s.findMin(num3));

    }
}
