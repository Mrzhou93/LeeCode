package src;

import java.util.HashSet;
import java.util.Set;

class N217containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for (int num: nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
