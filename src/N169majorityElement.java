package src;

class N169majorityElement {
    public int majorityElement(int[] nums) {  // 分治法求解
        return findMaj(nums, 0, nums.length-1);
    }

    private int findMaj(int[] nums, int s, int t){
        if (s == t)
            return nums[s];
        else {
            int mid = s + (t - s) / 2;
            int leftMaj = findMaj(nums, s, mid);
            int rightMaj = findMaj(nums, mid+1, t);

            if (leftMaj == rightMaj)
                return leftMaj;
            else {
                int leftCount = 0;
                int rightCount = 0;

                for (int i = s; i <= t; i++){
                    if (nums[i] == leftMaj)
                        leftCount++;
                    else if (nums[i] == rightMaj)
                        rightCount++;
                }

                if (leftCount > rightCount)
                    return leftMaj;
                else
                    return rightMaj;
            }
        }
    }
}
