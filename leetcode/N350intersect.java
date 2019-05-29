package leetcode;

import java.util.*;

class N350intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // value, count 统计相同的元素有多少个
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums1.length; i++){
            map.putIfAbsent(nums1[i], 0);
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }

        for (int j =0 ; j < nums2.length; j++){
            //如果nums2里面有和nums1相同的元素
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0){
                result.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int i=0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }


    public int[] intersection1(int[] num1, int[] num2) {
        // 方法未完成，（先排序，在二分查找有无此元素）

        if (num1.length < num2.length){
            int[] temp = num2;
            num2 = num1;
            num1 = temp;
        }

        quickSort(num1, 0, num1.length-1);
        List<Integer> re = new LinkedList<>();

//        for (int n: num1)
//            System.out.println(n);

        for (int num: num2){

            if (hasElem(num1, num)){
                re.add(num);
            }
        }

        int[] res = new int[re.size()];
        int k = 0;
        for (int num: re){
            res[k++] = num;
//            System.out.println(num);
        }
        return res;
    }

    private boolean hasElem(int[] num, int target){
        int i = 0, j = num.length - 1;

        while (i<=j){
            int mid = i + (j -i) / 2;
            if (num[mid] == target)
                return true;
            else if (num[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return false;
    }

    private void quickSort(int[] num, int s, int t){
        int i = s, j = t;
        if (s < t){
            int temp = num[s];
            while (i != j) {
                while (i < j && num[j] >= temp)
                    j--;
                num[i] = num[j];
                while (i < j && num[i] <= temp)
                    i++;
                num[j] = num[i];
            }
            num[i] = temp;
            quickSort(num, s, i - 1);
            quickSort(num, i + 1, t);
        }
    }

    public static void main(String[] args){
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};

        N350intersect s = new N350intersect();
//        s.intersection1(num2, num1);
        s.intersection1(num1, num2);
    }

}
