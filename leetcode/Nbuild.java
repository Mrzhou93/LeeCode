////package leetcode;
////
////import java.util.HashMap;
////import java.util.Map;
////
////class Nbuild {
////    public int howManyDelete(String s){
////        Map<Character, Integer> map = new HashMap<>();
////        int howmanydouble = 0;
////
////        for (int i= 0;i< s.length();i++){
////            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
////            if (map.containsKey(s.charAt(i)))
////                howmanydouble++;
////        }
////        if (howmanydouble == 0){
////            return s.length();
////        }
////
////        int start = 0, end = s.length() - 1;
////        while (start < end){
////            if (map.get(s.charAt(start)) > 1 || map.get(s.charAt(end)) > 1){
////                if (map.get(s.charAt(start)) > 1){
////
////                }
////            }
////
////            start++;
////            end--;
////        }
////
////    }
////}
//
//class Solution {
//    public String sort(String s){
//
//    }
//
//    private void quickSort(String str, int s, int t){
//
//        int i = s, j = t;
//        while(s < t){
//            char temp = str.charAt(s);
//            while(i < j){
//                while (i < j && str.charAt(j) > temp)
//                    j--;
//
//            }
//        }
//    }
//}
