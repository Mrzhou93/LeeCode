package src;

class N240searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        int col = matrix[0].length;

        if (col == 0)
            return false;

        int i = row-1;  // 搜索的行标记，从最大开始
        int j = 0;     // 搜索时的列标记，从最小开始

        while (i >= 0  && j < col ){
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)  // 如果目标值相对比较小，则向右移动位置
                i--;
            else
                j++;
        }
        return false;
    }
}
