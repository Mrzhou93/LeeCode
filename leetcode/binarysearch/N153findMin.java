package leetcode.binarysearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N153findMin {
    public int findMin(int[] nums) {
        return min(nums, 0, nums.length-1);
    }

    private int min(int[] nums, int start, int end){
        if (end == start)
            return nums[start];

        if (nums[start] < nums[end])
            return nums[start];

        if (end - start == 1)
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
        int[] num = {4, 5, 6, 7, 0, 1, 2};
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
