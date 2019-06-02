package leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/***
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */

public class N220containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums.length <= 1)
            return false;

        TreeMap<Integer,Integer>map = new TreeMap();

        for(int i = 0; i <= k && i < nums.length; i++)
        {
            Map.Entry<Integer,Integer> ceiling = map.ceilingEntry(nums[i]);
            Map.Entry<Integer,Integer> floor = map.floorEntry(nums[i]);
            if(ceiling != null && ceiling.getKey() <= nums[i] + t )
                return true;
            if(floor != null && nums[i] <= floor.getKey() + t)
                return true;
            map.put(nums[i],i);
        }

        for(int i = k+1; i < nums.length;i++)
        {
            int loc = map.get(nums[i-k-1]);
            if(loc < i-k)
                map.remove(nums[i-k-1] );

            Map.Entry<Integer,Integer> ceiling = map.ceilingEntry(nums[i]);
            Map.Entry<Integer,Integer> floor = map.floorEntry(nums[i]);
            if(ceiling != null && ceiling.getKey() <= nums[i] + t )
                return true;
            if(floor != null && nums[i] <= floor.getKey() + t)
                return true;
            map.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args){
        N220containsNearbyAlmostDuplicate s = new N220containsNearbyAlmostDuplicate();

        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
