package leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new LinkedList<>();

        if (matrix==null || matrix.length == 0)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] visited = new int[row][col];
        int curRow = 0;
        int curCol = 0;
        int drow = 0, dcol = 1;

        for (int i = 0; i < row * col; i++){
            result.add(matrix[curRow][curCol]);
            visited[curRow][curCol] = 1;

            if (visited[Math.abs(curRow + drow) % row][Math.abs(curCol + dcol) % col] == 1){
                int temp = dcol;
                dcol = - drow;
                drow = temp;
            }
            curRow += drow;
            curCol += dcol;
        }
        return result;
    }

    public static void main(String[] args){
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // [1,2,4,7,5,3,6,8,9]
        int[][] m1 = {{}, {}, {}};
        int[][] m2 = {{2, 3}};
        int[][] m3 = {{2, 5}, {8, 4}, {0, -1}};
        int[][] m4 = {{2, 8, 0}, {5, 4, -1}};
        int[][] m5 = {{1}, {2}, {3}};
        int[][] m6 = {};

        N54SpiralMatrix s = new N54SpiralMatrix();
        System.out.println(s.spiralOrder(m));
        System.out.println(s.spiralOrder(m1));
        System.out.println(s.spiralOrder(m2));
        System.out.println(s.spiralOrder(m3));
        System.out.println(s.spiralOrder(m4));
        System.out.println(s.spiralOrder(m5));
        System.out.println(s.spiralOrder(m6));
    }
}
