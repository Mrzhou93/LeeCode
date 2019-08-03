package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N229majorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int x = 0, y = 0;
        int cx = 0, cy = 0;

        for (int num: nums){
            if ((cx == 0 || num == x) && num != y){
                cx++;
                x = num;
            } else if (cy == 0 || num == y){
                cy++;
                y = num;
            } else {
                cx--;
                cy--;
            }
        }

        int xcount = 0, ycount = 0;
        for (int num: nums){
            if (num == x){
                xcount++;
            } else if (num == y){
                ycount++;
            }
        }

        if (xcount > nums.length / 3){
            ans.add(x);
        }

        if (ycount > nums.length / 3){
            ans.add(y);
        }

        return ans;
    }

    public static void main(String[] args) {
        N229majorityElement s = new N229majorityElement();

        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        System.out.println(s.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
