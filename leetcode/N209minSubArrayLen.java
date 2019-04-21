package leetcode;

class N209minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
//        int k = 0;
        int min = 0;
//        int sum = 0;

        for (int i=0; i< nums.length; i++){
            int sum = 0;
//            System.out.println(i);
            int k = i;
            while(k < nums.length && sum < s) {
//                System.out.println("    "+k);
                sum += nums[k];
                k++;
            }
            int tmp = k - i;
//            System.out.println("size of tmp:" + tmp);
            if (tmp < min && min != 0 && sum >= s){
                min = tmp;
            } else if(min == 0 && tmp> min && sum >= s){
                min = tmp;
            }
//            System.out.println("        min"+min);
        }
        return min;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};

        N209minSubArrayLen s = new N209minSubArrayLen();
        System.out.println(s.minSubArrayLen(7, nums));
    }
}
