package leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        for(int i=0; i< numRows; i++){
            List<Integer> curRows = new LinkedList<>();
            if (i == 0) {
                curRows.add(1);
            }else if(i == 1){
                curRows.add(1);
                curRows.add(1);
            }else{
                curRows.add(1);
                for (int j = 1; j < i ; j++){
                    curRows.add(result.get(i - 1).get(j-1)+ result.get(i-1).get(j));
                }
                curRows.add(1);
            }
            result.add(curRows);
        }
        return result;
    }

    public static void main(String[] args) {
        N118PascalTriangle s =new N118PascalTriangle();

        System.out.println(s.generate(4));
    }
}
