package src;
import java.util.*;

class N1027prefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {      // 有溢出的可能
        List<Boolean> result = new LinkedList<>();
        int toNum = 0;

        for (int i=0; i< A.length; i++){
            System.out.println(toNum);
            toNum = toNum * 2 + A[i];
            toNum %= 10;
            if (toNum % 5 == 0) {
                result.add(true);
            }
            else
                result.add(false);
        }
        return result;
    }

    public static void main(String[] args){

        int[] num1 = {0,1,1};
        int[] num2 = {1,1,1};
        int[] num3 = {0,1,1,1,1,1};
        int[] num4 = {1,1,1,0,1};
        int[] num5 = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};

        N1027prefixesDivBy5 s = new N1027prefixesDivBy5();
        System.out.println(s.prefixesDivBy5(num1));
        System.out.println(s.prefixesDivBy5(num2));
        System.out.println(s.prefixesDivBy5(num3));
        System.out.println(s.prefixesDivBy5(num4));
        System.out.println(s.prefixesDivBy5(num5));
    }
}
