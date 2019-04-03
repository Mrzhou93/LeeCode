package src;

class N154findMin {
    public int findMin(int[] nums){
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end])
                end = mid;
            else if (nums[mid] > nums[end])
                start = mid;
            else
                end--;
        }

        return nums[start] < nums[end] ? nums[start]: nums[end];
    }

    public static void main(String[] args){
        int[] num = {1, 3, 5};
        int[] num1 = {2, 2, 2, 0, 1};
        int[] num2 = {3, 3, 1, 3};
        int[] num3 = {1, 1, 3, 1};
        int[] num4 = {1, 3, 3};

        N154findMin s = new N154findMin();

        System.out.println(s.findMin(num));
        System.out.println(s.findMin(num1));
        System.out.println(s.findMin(num2));
        System.out.println(s.findMin(num3));
        System.out.println(s.findMin(num4));

    }
}
