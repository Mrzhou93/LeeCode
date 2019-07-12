package leetcode.array;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，
 * 我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *
 * 提示：
 *
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N1010numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int i, j, res = 0;
        for (i = 0; i< time.length; i++){
            for (j = i; j < time.length; j++){
                if (i < j && (time[i] + time[j]) % 60 == 0)
                    res++;
            }
        }
        return res;
    }


    public static void main(String[] args){
        N1010numPairsDivisibleBy60 s = new N1010numPairsDivisibleBy60();
        int[] num = {30,20,150,100,40};
        int[] num1 = {60, 60, 60};
        int[] num2 = {30};
        int[] num3 = {120};

        System.out.println(s.numPairsDivisibleBy60(num));
        System.out.println(s.numPairsDivisibleBy60(num1));
        System.out.println(s.numPairsDivisibleBy60(num2));
        System.out.println(s.numPairsDivisibleBy60(num3));
    }
}
