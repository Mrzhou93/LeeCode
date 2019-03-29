package src;
import java.util.*;


class Solution {
    public boolean canThreePartsEqualSum(int[] A){
        int sum = 0;
        int i = 0, j = A.length - 1;
        int frontSum = 0;
        int rearSum = 0;

        for (int num: A){
            sum += num;
        }
        System.out.println("sum"+sum);

        while (i + 1 < j){
            int mid = partSum(A, i , j);
            int front = partSum(A, 0, i);
            int rear = partSum(A, j, A.length-1);

            System.out.println(front);
            System.out.println(mid);

            if (front == sum / 3 && rear == sum / 3 && mid == sum / 3)
                return true;
            if (front < sum / 3)
                i++;
            if (rear < sum / 3)
                j--;
        }

        System.out.println(i);
        System.out.println(j);

        if (A[i] == sum / 3)
            return true;

        return false;
    }

    private int partSum(int[] A, int i, int j){
        int sum = 0;
        if (i < j){
            for(int k = i; k < j; k++){
                sum += A[k];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] num1 = {0,2,1,-6,6,-7,9,1,2,0,1};
        int[] num2 = {3,3,6,5,-2,2,5,1,-9,4};
        int[] num3 = {0,2,1,-6,6,7,9,-1,2,0,1};
        Solution s = new Solution();
        System.out.println(s.canThreePartsEqualSum(num1));
        System.out.println(s.canThreePartsEqualSum(num2));
        System.out.println(s.canThreePartsEqualSum(num3));
    }
}

//class Solution {
//    public int smallestRepunitDivByK(int K) {
//        int num = 1, length = 1;
//
//
//    }
//}


//class Solution {
//    public boolean queryString(String S, int N) {
//        int num = 0;
//        int length = S.length();
//
//        while(length >)
//    }
//}