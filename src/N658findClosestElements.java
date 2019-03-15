package src;

import java.util.LinkedList;
import java.util.List;

public class N658findClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = arr.length - 1;
        int startIndex = -1, index = -1;
        List<Integer> res = new LinkedList<>();

        while (i + 1 < j){
            int mid = i + (j - i) / 2;
            if (arr[mid] == x)
                break;
            else if (arr[mid] < x)
                i = mid;
            else
                j = mid;
        }

        if (arr[i + (j - i) / 2] == x) {
            startIndex = i + (j - i) / 2;
        }
        else if (arr[i] == x) {
            startIndex = i;
        }
        else if (arr[j] == x) {
            startIndex = j;
        }
        else if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)){
            startIndex = j;
        }
        else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)){
            startIndex = i;
        }
        else if (arr[0] > x) {        // 返回前k个
            startIndex = 0;
        }
        else {                        // 返回后面k个
            startIndex = arr.length - 1;
        }

        index = startIndex;
        int counter = 1;
        while (counter < k && startIndex > 0 && index < arr.length - 1){
            if (Math.abs(arr[startIndex - 1] - x) <= Math.abs(arr[index + 1] - x)){
                startIndex--;
            } else {
                index++;
            }
            counter++;
        }

        if (index - startIndex + 1 != k)
            if (index == arr.length - 1)
                startIndex = index - k+ 1;

        int count = 0;
        while (count < k){
            res.add(arr[startIndex++]);
            count++;
        }

        return res;
    }

    public static void main(String[] args){
        int[] num = {1, 2, 3, 4, 5};    // [1, 2, 3, 4]
        int[] num1 = {0, 1, 2, 2, 2, 3, 6, 8, 8, 9};
        int[] num2 = {1, 2, 5, 5, 6, 6, 7, 7, 8, 9};
        int[] num3 = {0, 0, 0, 1, 3, 5, 6, 7, 8, 8};  // [1, 3]

        N658findClosestElements s = new N658findClosestElements();
        System.out.println(s.findClosestElements(num, 4, 3));
        System.out.println(s.findClosestElements(num1, 5, 9));
        System.out.println(s.findClosestElements(num2, 7, 7));
        System.out.println(s.findClosestElements(num3, 2, 2));

    }
}
