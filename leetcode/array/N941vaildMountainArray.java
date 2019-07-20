package leetcode.array;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N941vaildMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;


        int maxIndex = 0;
        for (int i = 1; i < A.length; i++){
            if (A[i] > A[maxIndex]){
                maxIndex = i;
            }
        }

        if (maxIndex == 0 || maxIndex == A.length - 1)
            return false;

//        System.out.println(increase(A, maxIndex));
//        System.out.println(decrease(A, maxIndex));

        return increase(A, maxIndex) && decrease(A, maxIndex);
    }

    public boolean increase(int[] A, int x){
        for (int i = 0; i < x; i++){
            if (A[i] >= A[i + 1])
                return false;
        }
        return true;
    }

    public boolean decrease(int[] A, int x){
        for (int i = x; i < A.length - 1; i++){
            if (A[i] <= A[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        N941vaildMountainArray s = new N941vaildMountainArray();

        System.out.println(s.validMountainArray(new int[]{2, 1}));
        System.out.println(s.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(s.validMountainArray(new int[]{0, 3, 2, 1}));
    }
}
