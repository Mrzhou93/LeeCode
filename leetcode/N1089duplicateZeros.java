package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */

public class N1089duplicateZeros {
    public void duplicateZeros(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++){
            list.add(arr[i]);

            if (arr[i] == 0){
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }

//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        N1089duplicateZeros s = new N1089duplicateZeros();

        s.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        s.duplicateZeros(new int[]{1, 2, 3});
    }
}
