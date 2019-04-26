package leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * */

public class N79exist {

    private int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if (dfs(board, i, j, 1, word, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int depth, String word, boolean[][] visited){
        if (depth == word.length())
            return true;

        for (int k = 0; k < move.length; k++){
            int newi = i + move[k][0];
            int newj = j + move[k][1];
            if ((newi >= 0 && newi < board.length) && (newj >= 0 && newj < board[0].length)
                    && board[newi][newj] == word.charAt(depth) && !visited[newi][newj]){
                visited[newi][newj] = true;
                if (dfs(board, newi, newj, depth + 1, word, visited)) {
                    return true;
                }
                visited[newi][newj] = false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        N79exist s= new N79exist();

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E' ,'E'}};

        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(!s.exist(board, "ABCB"));
    }
}
