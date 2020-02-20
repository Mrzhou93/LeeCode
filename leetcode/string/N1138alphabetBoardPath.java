package leetcode.string;

/**
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 *
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 *
 * 我们可以按下面的指令规则行动：
 *
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 *
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 *
 *
 * 提示：
 *
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 */

public class N1138alphabetBoardPath {

    private StringBuilder sb;
    // board = ["abcde",
    //          "fghij",
    //          "klmno",
    //          "pqrst",
    //          "uvwxy",
    //          "z"].

    public String alphabetBoardPath(String target) {
        sb = new StringBuilder();

        int curRow = 0;
        int curCol = 0;
        int curVal = 0;
        int targetRow = 0;
        int targetCol = 0;
        boolean isz = false;
        boolean zin = false;

        for (int i = 0; i < target.length(); i++){
            int c = target.charAt(i) - 'a';

            if (c == curRow * 5 + curCol){
                sb.append('!');
                continue;
            }

            if (c == 'z' - 'a'){
                targetRow = 4;
                targetCol = 0;
                zin = true;
            }else {
                targetRow = c / 5;
                targetCol = c % 5;
            }

            if (curRow * 5 + curCol == 'z' - 'a'){
                sb.append('U');
//                curCol--;
                curRow--;
//                System.out.println("i"+curCol);
//                System.out.println(curRow);
            }

//            goCol(targetCol, curCol);
//            goRow(targetRow, curRow);

            while (targetCol > curCol){
                sb.append('R');
                curCol++;
            }
            while (targetCol < curCol){
                sb.append('L');
                curCol--;
            }

            while (targetRow > curRow){
                sb.append('D');
                curRow++;
            }
            while (targetRow < curRow){
                sb.append('U');
                curRow--;
            }

            if (zin){
                sb.append('D');
//                curCol++;
                curRow++;
                zin = false;
            }
            sb.append('!');

//            System.out.println(curRow);
//            System.out.println(curCol);

        }
        return sb.toString();
    }

    public void goCol(int targetCol, int curCol){
        while (targetCol > curCol){
            sb.append('R');
            curCol++;
        }
        while (targetCol < curCol){
            sb.append('L');
            curCol--;
        }
    }

    public void goRow(int targetRow, int curRow){
        while (targetRow > curRow){
            sb.append('D');
            curRow++;
        }
        while (targetRow < curRow){
            sb.append('U');
            curRow--;
        }
    }

    public static void main(String[] args) {
        N1138alphabetBoardPath s = new N1138alphabetBoardPath();
//        System.out.println('z' - 'a');

        System.out.println(s.alphabetBoardPath("leet"));
        System.out.println(s.alphabetBoardPath("code"));
        System.out.println(s.alphabetBoardPath("zdz"));
        System.out.println(s.alphabetBoardPath("zzb"));  // "DDDDD!UUUUUR!"
    }
}
