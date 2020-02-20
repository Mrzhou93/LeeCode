package leetcode.lcof;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N12exist {

    private int[][] visited;
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = 1;
                    if (hasPath(board, word, 1, i, j)){
                        return true;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, String word, int indexOfWord,
                            int curRow, int curCol){
        if (indexOfWord == word.length()){
            return true;
        }

        for (int[] d: dirs){
            int nextRow = curRow + d[0];
            int nextCol = curCol + d[1];
            if ((nextRow >= 0 && nextRow < board.length) &&
                    (nextCol >= 0 && nextCol < board[0].length) &&
                    board[nextRow][nextCol] == word.charAt(indexOfWord) &&
                    visited[nextRow][nextCol] == 0) {

//                System.out.println("row=" + nextRow + " col=" + nextCol);

                visited[nextRow][nextCol] = 1;
                if (hasPath(board, word, indexOfWord + 1, nextRow, nextCol)){
                    return true;
                }
                visited[nextRow][nextCol] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N12exist s = new N12exist();
        System.out.println(s.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}}, "ABCCED"));

        System.out.println(s.exist(new char[][]{
                {'a','b'},{'c','d'}}, "abcd"));
    }
}
