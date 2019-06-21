package leetcode;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class N542UpdateMatrix {

    private int row;
    private int col;
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 优化：如果元素在 0 附近，保留元素值 1，不在 0 附近，初始化为一个较大值
                if (matrix[i][j] == 1
                        && !((i > 0 && matrix[i - 1][j] == 0)
                        || (i < row - 1 && matrix[i + 1][j] == 0)
                        || (j > 0 && matrix[i][j - 1] == 0)
                        || (j < col - 1 && matrix[i][j + 1] == 0))) {
                    matrix[i][j] = row + col;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 优化：将元素值为 1 的点作为深搜起点，降低递归深度
                if (matrix[i][j] == 1) {
                    updateMatrix(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    private void updateMatrix(int[][] matrix, int r, int c) {
        // 搜索上下左右四个方向
        for (int[] v : vector) {
            int nr = r + v[0], nc = c + v[1];
            if (nr >= 0 && nr < row
                    && nc >= 0 && nc < col
                    && matrix[nr][nc] > matrix[r][c] + 1) {
                matrix[nr][nc] = matrix[r][c] + 1;
                updateMatrix(matrix, nr, nc);
            }
        }
    }
}
