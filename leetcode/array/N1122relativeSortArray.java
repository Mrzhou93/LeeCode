package leetcode.array;


import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N1122relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        int time = 0;

        for (int x: arr1){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length){
            time = map.get(arr2[j]);

            map.remove(arr2[j]);
            for (int k = 0; k < time; k++){
                arr1[i++] = arr2[j];
            }
            j++;
        }

        if (!map.isEmpty()){
            for (int k: map.keySet()){
                time = map.get(k);
                for (int t = 0; t < time; t++){
                    arr1[i++] = k;
                }
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        N1122relativeSortArray s = new N1122relativeSortArray();

        System.out.println(Arrays.toString(s.relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6})));
    }
}
