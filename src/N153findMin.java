package src;

class N153findMin {
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

    public int findMin1(int[] nums){
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end])
                end = mid;
            else
                start = mid;
        }

        return nums[start] < nums[end]? nums[start]:nums[end];
    }

    public static void main(String[] args){
        int[] num = {4,5,6,7,0,1,2};
        int[] num1 = {1};
        int[] num2 = {2, 1};
        int[] num3 = {3, 1, 2};

        N153findMin s = new N153findMin();

        System.out.println(s.findMin1(num));
        System.out.println(s.findMin1(num1));
        System.out.println(s.findMin1(num2));
        System.out.println(s.findMin1(num3));

    }
}
