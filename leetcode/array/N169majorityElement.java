package leetcode.array;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

class N169majorityElement {
    public int majorityElement(int[] nums) {  // 分治法求解
        return findMaj(nums, 0, nums.length-1);
    }

    private int findMaj(int[] nums, int s, int t){
        if (s == t)
            return nums[s];
        else {
            int mid = s + (t - s) / 2;
            int leftMaj = findMaj(nums, s, mid);
            int rightMaj = findMaj(nums, mid+1, t);

            if (leftMaj == rightMaj)
                return leftMaj;
            else {
                int leftCount = 0;
                int rightCount = 0;

                for (int i = s; i <= t; i++){
                    if (nums[i] == leftMaj)
                        leftCount++;
                    else if (nums[i] == rightMaj)
                        rightCount++;
                }

                if (leftCount > rightCount)
                    return leftMaj;
                else
                    return rightMaj;
            }
        }
    }

    public static void main(String[] args){
        N169majorityElement s = new N169majorityElement();


        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
    }
}
