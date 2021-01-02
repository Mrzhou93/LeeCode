package leetcode.array;


/**
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 *
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *  
 * 提示：
 *
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N954canReorderDoubled {
    public boolean canReorderDoubled(int[] A) {
        int[] neg = new int[100001];
        int[] pos = new int[100001];

        int negNum = 0;
        int posNum = 0;

        for (int a: A){
            if (a > 0){
                pos[a]++;
                posNum++;
            } else if (a < 0){
                pos[-a]++;
                negNum++;
            }
        }

        if (posNum % 2 != 0 || negNum % 2 != 0){
            return false;
        }

        for (int i = 1; i < 100001; i++){
            if (pos[i] > 0){
                pos[2 * i] -= pos[i];
            } else if (pos[i] < 0){
                return false;
            }

            if (neg[i] > 0){
                neg[2 * i] -= neg[i];
            } else if (neg[i] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        N954canReorderDoubled s = new N954canReorderDoubled();
        System.out.println(s.canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(s.canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(s.canReorderDoubled(new int[]{4, -2, 2, -4}));
        System.out.println(s.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
    }
}
