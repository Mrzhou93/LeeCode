package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N59generateMatrix {

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int num = n * n;
        int row = 0;
        int col = 0;
        int d = 0;

        for (int i = 1; i <= num; i++){
//            System.out.println("row=" + row + " col=" + col);
//            System.out.println("drow=" + (row + direction[d][0]) % n +
//                    " col=" + (col + direction[d][1]) % n);
//            System.out.println(col);

            ans[row][col] = i;

            if (ans[Math.abs(row + direction[d][0]) % n][Math.abs(col + direction[d][1]) % n] != 0){
                d = (d + 1) % 4;
            }

            row += direction[d][0];
            col += direction[d][1];
        }

        return ans;
    }

    public static void main(String[] args) {
        N59generateMatrix s = new N59generateMatrix();

        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
        System.out.println(Arrays.deepToString(s.generateMatrix(4)));
    }
}
