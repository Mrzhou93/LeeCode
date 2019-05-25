package leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是0，所以你永远不可能到达最后一个位置。
 * */

class N55canJump {
    public boolean canJump(int[] nums){
        if (nums.length == 0)
            return false;

        if (nums.length == 1)
            return true;

        if (nums[0] == 0 )
            return false;

        boolean canReach[] = new boolean[nums.length];
        canReach[0] = true;

        for (int i = 0; i < nums.length; i++){
            for (int j = nums[i]; j > 0; j--){
                if (canReach[i]  && i+j < nums.length)
                    canReach[i+j] = true;
            }
        }
        return canReach[nums.length - 1];
    }

    public static void main(String[] args){
        N55canJump s = new N55canJump();

        int[] num = {2, 3, 1, 1, 4};
        int[] num1 = {3, 2, 1, 0, 4};
        int[] num2 = {0, 2, 3};
        int[] num3 = {0};
        int[] num4 = {1, 0, 1, 0};

        System.out.println(s.canJump(num));
        System.out.println(s.canJump(num1));
        System.out.println(s.canJump(num2));
        System.out.println(s.canJump(num3));
        System.out.println(s.canJump(num4));
    }
}
