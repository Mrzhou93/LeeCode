//package leetcode;
//
//import java.util.*;
//
//class NtopKFrequent {
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> map1 = new HashMap<>();
//
//        for (int i = 0; i< nums.length; i++){
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        for (int key: map.keySet()){
//            map1.put(map.get(key), key);
//        }
//
//
//
//    }
//}
