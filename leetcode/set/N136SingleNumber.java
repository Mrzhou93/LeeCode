package leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

class N136SingleNumber {
    public int singleNumber(int[] nums){

        Set<Integer> myHashSet = new HashSet<>();
        Set<Integer> doubleNum = new HashSet<>();

        for (int num: nums){
            if (myHashSet.contains(num))
                doubleNum.add(num);
            else
                myHashSet.add(num);
        }

        for(int num: myHashSet){
            if (!doubleNum.contains(num))
                return num;
        }
        return 0;
    }

    public static void main(String[] args){
        int[] num1 = {2, 2, 1};

        N136SingleNumber s = new N136SingleNumber();
        System.out.println(s.singleNumber(num1));
    }
}
