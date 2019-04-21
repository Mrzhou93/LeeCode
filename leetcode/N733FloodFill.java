package leetcode;

class N733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int[][] visited = new int[image.length][image[0].length];

        bfs(image, sr, sc, newColor, visited, image[sr][sc]);

        return image;
    }

    private void bfs(int[][] image, int row, int col, int newColor, int[][] visited, int oldColor){
        if (row >= 0 && row<image.length &&
                col>=0 && col<image[0].length &&
                visited[row][col]==0 && image[row][col]==oldColor){

            visited[row][col]=1;
            image[row][col]=newColor;

            bfs(image, row-1, col, newColor, visited, oldColor);
            bfs(image, row+1, col, newColor, visited, oldColor);
            bfs(image, row, col-1, newColor, visited, oldColor);
            bfs(image, row, col+1, newColor, visited, oldColor);
        }
    }

}
