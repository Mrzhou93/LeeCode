package src;

class N542UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix[0].length; j++){
                if (result[i][j] == 0)
                    bfs(matrix, i, j, result, visited);
            }
        }
        return result;
    }

    private void bfs(int[][] matrix, int row, int col, int[][] result, int[][] visited){
        if (row>=0 && row <matrix.length &&
                col>=0 && col < matrix[0].length &&
                matrix[row][col]!=0 ){  // && visited[row][col]==0
            result[row][col] ++;
            //visited[row][col] = 1;


            bfs(matrix, row-1, col, result, visited);
            bfs(matrix, row+1, col, result, visited);
            bfs(matrix, row, col-1, result, visited);
            bfs(matrix, row, col+1, result, visited);
        }
    }
}
