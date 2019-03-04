package src;

public class N260SingleNumber {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}
