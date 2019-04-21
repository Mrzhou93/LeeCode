package leetcode;

import java.util.Arrays;

public class N498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int currentRow = 0;
        int currentCol = 0;
        int level = 0;
        int index = 0;
        int[] result = new int[row * col];

        while(currentRow < row && currentRow>=0 && currentCol>=0 && currentCol < col && index < row*col){ //
            if (level % 2 ==0) {
                result[index++] = matrix[currentRow--][currentCol++];
            }else{
                result[index++] = matrix[currentRow++][currentCol--];
            }

            if ((level % 2 ==0) && (currentRow < 0 || currentCol >= col)){
                level++;
                if (currentRow < 0 && currentCol < col){
                    currentRow = 0;
                }else if (currentRow < 0 && currentCol >= col){
                    currentRow = currentRow + 2;
                    currentCol = col - 1;
                } else {
                    currentRow = currentRow + 2;
                    currentCol = col - 1;
                }
            } else if((level % 2 != 0) && (currentRow >= row || currentCol <0)){
                level++;
                if (currentRow >= row){
                    currentRow = row - 1;
                    currentCol = currentCol + 2;
                }
                else {
                    currentCol = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  // [1,2,4,7,5,3,6,8,9]
        int[][] m1 = {{}, {}, {}};
        int[][] m2 = {{2, 3}};
        int[][] m3 = {{2, 5}, {8, 4}, {0, -1}};
        int[][] m4 = {{2, 8, 0}, {5, 4, -1}};

        N498DiagonalTraverse s = new N498DiagonalTraverse();
        System.out.println(Arrays.toString(s.findDiagonalOrder(m)));
        System.out.println(Arrays.toString(s.findDiagonalOrder(m1)));
        System.out.println(Arrays.toString(s.findDiagonalOrder(m2)));
        System.out.println(Arrays.toString(s.findDiagonalOrder(m3)));
        System.out.println(Arrays.toString(s.findDiagonalOrder(m4)));
    }
}
