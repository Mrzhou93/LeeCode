package leetcode;

public class N561ArrayPartition {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        int result = 0;

        for (int i = 0; i< nums.length/2; i++){
            result += nums[2*i];
        }
        return result;
    }

    private void quickSort(int[] nums, int s, int t){
        int i = s, j = t;
        int temp;
        if (s < t){
            temp = nums[s];
            while(i != j){
                while (j > i && nums[j] >= temp)
                    j--;
                nums[i] = nums[j];

                while(i < j && nums[i] <= temp)
                    i++;
                nums[j] = nums[i];
            }
            nums[i] = temp;

            quickSort(nums, s, i-1);
            quickSort(nums, i+1, t);
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 4, 3, 2};

        N561ArrayPartition s = new N561ArrayPartition();
        System.out.println(s.arrayPairSum(nums));
    }
}
