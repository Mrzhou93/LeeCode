package leetcode.binarysearch;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N74searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;

        if (row == 0)
            return false;

        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right){
            int curIndex = left + (right - left) / 2;
            int curElem = matrix[curIndex / col][curIndex % col];
            if (curElem == target){
                return true;
            } else if (curElem < target){
                left = curIndex + 1;
            } else {
                right = curIndex - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N74searchMatrix s = new N74searchMatrix();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        System.out.println(s.searchMatrix(matrix, 3));
        System.out.println(s.searchMatrix(matrix, 13));
    }
}
