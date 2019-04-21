package leetcode;

import java.util.HashSet;
import java.util.Set;

class N136SingleNumber {

    public int singleNumber(int[] nums){

        Set<Integer> myHashSet = new HashSet<>();
        Set<Integer> doubleNum = new HashSet<>();

        for (int num: nums){
            if (myHashSet.contains(num))
                doubleNum.add(num);
            else
                myHashSet.add(num);
        }

        for(int num: myHashSet){
            if (!doubleNum.contains(num))
                return num;
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        int result=0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args){
        int[] num1 = {2, 2, 1};

        N136SingleNumber s = new N136SingleNumber();
        System.out.println(s.singleNumber(num1));
    }
}
