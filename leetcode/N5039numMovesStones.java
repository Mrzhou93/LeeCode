package leetcode;

import java.util.Arrays;

/**
 * 三枚石子放置在数轴上，位置分别为 a，b，c。
 *
 * 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，
 * 并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 *
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 *
 * 当游戏结束时，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回：answer = [minimum_moves, maximum_moves]
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2, c = 5
 * 输出：[1, 2]
 * 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 * 示例 2：
 *
 * 输入：a = 4, b = 3, c = 2
 * 输出：[0, 0]
 * 解释：我们无法进行任何移动。
 * */

public class N5039numMovesStones {
    public int[] numMovesStones(int a, int b, int c) {
        int[] place = new int[]{a, b, c};
        Arrays.sort(place);

//        System.out.println(Arrays.toString(place));

        int[] res = new int[2];

        res[0] = 2;
        res[1] = (place[1] - place[0] - 1) + (place[2] - place[1] - 1);

        if (place[1] - place[0] == 2 || place[2] - place[1] == 2 ||
                place[0] + 1 == place[1] || place[1] + 1== place[2])
            res[0] = 1;

        if (place[1] - place[0] == 1 && place[2] - place[1] == 1)
            res[0] = 0;

        return res;
    }



    public static void main(String[] args){
        N5039numMovesStones s = new N5039numMovesStones();

        System.out.println(Arrays.toString(s.numMovesStones(1, 2, 5))); // [1, 2]
        System.out.println(Arrays.toString(s.numMovesStones(4, 3, 2))); // [0, 0]
//        System.out.println(Arrays.toString(s.numMovesStones(3, 5, 1))); // [1, 2]
    }

}
