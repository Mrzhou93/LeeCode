package leetcode;

import java.util.LinkedList;
import java.util.List;

class N118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        for(int i=0; i< numRows; i++){
            List<Integer> curRows = new LinkedList<>();
            if (i == 0) {
                curRows.add(1);
            }else if(i == 1){
                curRows.add(1);
                curRows.add(1);
            }else{
                curRows.add(1);
                for (int j = 1; j < i ; j++){
                    curRows.add(result.get(i - 1).get(j-1)+ result.get(i-1).get(j));
                }
                curRows.add(1);
            }
            result.add(curRows);
        }
        return result;
    }
}
