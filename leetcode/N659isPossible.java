package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个按升序排序的整数数组（可能包含重复数字），
 * 你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。
 * 返回你是否能做出这样的分割？
 *
 *
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 *
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 提示：
 * 输入的数组长度范围为 [1, 10000]
 */

public class N659isPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();

        for (int num: nums){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

//        System.out.println(numMap.toString());

        for (int num: nums){
            if (numMap.get(num) == 0){
                continue;
            }
            if (endMap.containsKey(num - 1) && endMap.get(num - 1) > 0){
                numMap.put(num, numMap.get(num) - 1);
                endMap.put(num - 1, endMap.get(num - 1) - 1);

                if (endMap.containsKey(num)){
                    endMap.put(num, endMap.get(num) + 1);
                }else {
                    endMap.put(num, 1);
                }
            } else if (numMap.containsKey(num + 1) && numMap.containsKey(num + 2) &&
                    numMap.get(num + 1) != 0 && numMap.get(num + 2) != 0){
                numMap.put(num, numMap.get(num) - 1);
                numMap.put(num + 1, numMap.get(num + 1) - 1);
                numMap.put(num + 2, numMap.get(num + 2) - 1);
                if (endMap.containsKey(num + 2)){
                    endMap.put(num + 2, endMap.get(num + 2) + 1);
                }else{
                    endMap.put(num + 2, 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        N659isPossible s = new N659isPossible();
        System.out.println(s.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(s.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(s.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
