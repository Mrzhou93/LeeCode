package src;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * */

class N63uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 1)
            dp[0][0] = 0;
        else
            dp[0][0] = 1;

        for (int i = 1; i < obstacleGrid.length; i++){
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = dp[i - 1][0];
            else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++){
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = dp[0][i -1];
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args){
        int[][] grad = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] grad1 = {{1}};
        int[][] grad2 = {{1, 0}};

        N63uniquePathsWithObstacles s = new N63uniquePathsWithObstacles();
        System.out.println(s.uniquePathsWithObstacles(grad)); // 2
        System.out.println(s.uniquePathsWithObstacles(grad1)); // 0
        System.out.println(s.uniquePathsWithObstacles(grad2)); // 0
    }
}
