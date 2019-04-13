//package src;
//import java.util.*;
//
//
//class Solution {
//    public String citys(int n, int k, int[] hotels){
//        int hotelSum = 0;
//        int res[] = new int[k + 1];
//
//        for (int num: hotels){
//            hotelSum += num;
//        }
//
//        int sum = 0;
//        int j = 1;
//
//        for (int i = 0; i < n; i++) {
//            sum += hotels[i];
//
//            if (sum > hotelSum / k) {
//                System.out.println(j);
////                sum = 0;
//                res[j] = sum - res[j - 1];
//                j++;
//            }
//        }
//
////        for (int re: res)
////            System.out.println(re);
//
//        return "";
//    }
//
//    public static void main(String[] args){
//        Solution s = new Solution();
//        System.out.println(s.citys(9, 3, new int[]{1, 2, 3, 1, 1, 3, 2, 3, 4}));
//
//    }
//}
