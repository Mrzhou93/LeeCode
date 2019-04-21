package leetcode;

import java.util.HashMap;
import java.util.Map;

class N454fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int numA: A){
            for (int numB: B){
                int n = numA + numB;
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        for (int numC: C){
            for (int numD: D){
                int n = numC + numD;
                if (map.containsKey(-n)){
                    result += map.get(-n);
                }
            }
        }
        return result;
    }
}
