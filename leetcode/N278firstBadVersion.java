//package leetcode;
//
//class NfirstBadVersion {
//    public int firstBadVersion(int n) {
//        int i = 1, j = n;
//        int mid = n;
//
//        while (i < j){
//            mid = i + (j - i) / 2;
//            if (isBadVersion(mid)){
//                j = mid;
//            } else {
//                i = mid + 1;
//            }
//        }
//
//        if (isBadVersion(j))
//            return j;
//
//        return -1;
//    }
//}
