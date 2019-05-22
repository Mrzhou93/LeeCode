package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class N659isPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();

        for (int num: nums){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

//        System.out.println(numMap.toString());

        for (int num: nums){
            if (numMap.get(num) == 0){
                continue;
            }
            if (endMap.containsKey(num - 1) && endMap.get(num - 1) > 0){
                numMap.put(num, numMap.get(num) - 1);
                endMap.put(num - 1, endMap.get(num - 1) - 1);

                if (endMap.containsKey(num)){
                    endMap.put(num, endMap.get(num) + 1);
                }else {
                    endMap.put(num, 1);
                }
            } else if (numMap.containsKey(num + 1) && numMap.containsKey(num + 2) &&
                    numMap.get(num + 1) != 0 && numMap.get(num + 2) != 0){
                numMap.put(num, numMap.get(num) - 1);
                numMap.put(num + 1, numMap.get(num + 1) - 1);
                numMap.put(num + 2, numMap.get(num + 2) - 1);
                if (endMap.containsKey(num + 2)){
                    endMap.put(num + 2, endMap.get(num + 2) + 1);
                }else{
                    endMap.put(num + 2, 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        N659isPossible s = new N659isPossible();
        System.out.println(s.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(s.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(s.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
