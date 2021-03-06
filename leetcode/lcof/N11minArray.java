package leetcode.lcof;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2] [4,5,1,2,3] [1,2,3,4,5]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N11minArray {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;

        while (i <= j){
            int mid = i + (j - i) / 2;
            if (numbers[mid] > numbers[j]){
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]){
                j = mid;
            } else {
                j--;
            }
        }

        return numbers[i];
    }

    public static void main(String[] args) {
        N11minArray s = new N11minArray();

        System.out.println(s.minArray(new int[]{3,4,5,1,2}));
        System.out.println(s.minArray(new int[]{2,2,2,0,1}));
    }
}
