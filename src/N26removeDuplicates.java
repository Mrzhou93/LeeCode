package src;

class N26removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int k = 0, i = 0 ;

        while(i < nums.length){
            if (nums[k] == nums[i])
                i++;
            else{
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        N26removeDuplicates s = new N26removeDuplicates();
        System.out.println(s.removeDuplicates(nums));
    }
}
