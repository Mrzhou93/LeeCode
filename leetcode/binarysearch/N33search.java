package leetcode.binarysearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

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
