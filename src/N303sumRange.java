package src;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。*/

class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;

        sum = new int[nums.length];

        sum[0] = nums[0];

        for (int i=1; i<nums.length; i++){
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public void print(){
        for (int i=0;i<sum.length;i++){
            System.out.println(sum[i]);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sum[j];
        else
            return sum[j] - sum[i - 1];
    }

    public static void main(String args[]){
        int[] num = {-2, 0, 3, -5, 2, -1};

        NumArray s = new NumArray(num);
        System.out.println(s.sumRange(0, 2));
        System.out.println(s.sumRange(2, 5));
        System.out.println(s.sumRange(0, 5));
    }
}
