package src;

/**
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。那么数组 A 是漂亮数组。
 *
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：5
 * 输出：[3,1,2,5,4]
 *
 * 解法：
 * 因为A[k] * 2必定为偶数
 * 以中间的某个数字，前面全部放奇数，后面全部放偶数。
 *
 * */


class N932beautifulArray {
    public int[] beautifulArray(int N) {
        int[] result = new int[N];

        if (N == 1){
            return new int[]{1};
        } else {
            int[] oddArray = beautifulArray((N + 1) / 2);
            for (int i = 0; i< oddArray.length; i++){
                result[i] = oddArray[i] * 2 - 1;
            }

            int[] evenArray = beautifulArray(N / 2);
            for (int i = 0; i < evenArray.length; i++){
                result[((N + 1) / 2) + i] = 2 * evenArray[i];
            }
        }
        return result;
    }

    public void printArray(int[] array){
        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String args[]){
        N932beautifulArray s= new N932beautifulArray();

        s.printArray(s.beautifulArray(4));
    }
}
