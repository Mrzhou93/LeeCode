package src;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 * */

class N304NumMatrix {

    private int[][] dp;

    public N304NumMatrix(int[][] matrix) {

        int row = matrix.length;

        if (row == 0)
            return;

        int col = matrix[0].length;

        if (col == 0)
            return;

        this.dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                if (i == 1 && j == 1)
                    this.dp[i][j] = matrix[i - 1][j - 1];

                else if (i == 1) {
//                    System.out.println("i = "+ 1 + "j = "+ j);
                    this.dp[i][j] = this.dp[i][j - 1] + matrix[i - 1][j - 1];
                }
                else if (j == 1) {
                    this.dp[i][j] = this.dp[i - 1][j] + matrix[i - 1][j - 1];
                }
                else{
                    this.dp[i][j] = matrix[i - 1][j - 1] + this.dp[i - 1][j - 1] +
                            (this.dp[i - 1][j] - this.dp[i - 1][j - 1]) +
                            (this.dp[i][j - 1] - this.dp[i - 1][j - 1]);
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.dp[row2+ 1][col2 + 1] - this.dp[row2 + 1][col1] - this.dp[row1][col2 + 1]
                + this.dp[row1][col1];
    }

    public void print() {
        System.out.println("=======================");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

    public static void main(String [] args){
        int[][] matrix = {  {3, 0, 1, 4, 2},
                            {5, 6, 3, 2, 1},
                            {1, 2, 0, 1, 5},
                            {4, 1, 0, 1, 7},
                            {1, 0, 3, 0, 5}};


        N304NumMatrix s= new N304NumMatrix(matrix);
        s.print();

        System.out.println(s.sumRegion(2, 1, 4, 3));        // 8
        System.out.println(s.sumRegion(0, 0, 1, 1));        // 14
        System.out.println(s.sumRegion(0, 0, 1, 1));        // 14

        int[][] matrix1 = {{}};
        N304NumMatrix s1= new N304NumMatrix(matrix1);

        int[][] matrix2 = {{-4, -5}};
        N304NumMatrix s2= new N304NumMatrix(matrix2);
        s2.print();
        System.out.println(s2.sumRegion(0,0,0,0));
        System.out.println(s2.sumRegion(0,0,0,1));
        System.out.println(s2.sumRegion(0,1,0,1));

    }
}
