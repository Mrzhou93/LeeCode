package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 拍年度纪念照时，要求学生按照高度非递减的顺序排列。
 *
 * 返回没有站在正确位置的学生人数。（该人数是能让所有学生以不递减高度排列的必要移动人数。）
 *
 *
 * 示例：
 *
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生没有站在正确的位置。
 *
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */

public class N1051heightChecker {
    public int heightChecker(int[] heights) {
        int[] oldHeight = Arrays.copyOfRange(heights, 0, heights.length);
        int ans = 0;
        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++){
            if (oldHeight[i] != heights[i])
                ans++;
        }
        return ans;
    }


    public static void main(String[] args){
        N1051heightChecker s = new N1051heightChecker();

        System.out.println(s.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
