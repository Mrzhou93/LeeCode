package src;

class NmaxSubArray {
    public int maxSubArray(int[] nums) {

        int max = 0, maxI = 0, maxJ = nums.length - 1;
        int i = 0, j = nums.length - 1;

        for (int num: nums)
            max += num;

        while(i < j){
            if (max - nums[maxI + 1] > max){
                max = max - nums[maxI + 1];
                maxI = maxI + 1;
//                System.out.println("i"+i);
            }
            i++;

            if (max - nums[maxJ - 1] > max){
                max = max - nums[maxJ - 1];
                maxJ = maxJ - 1;
//                System.out.println("j"+j);
            }
            j--;
//            System.out.println("max"+max);
        }
    return max;
    }

    public static void main(String[] args){
        int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        NmaxSubArray s = new NmaxSubArray();
        System.out.println(s.maxSubArray(num));
    }
}
