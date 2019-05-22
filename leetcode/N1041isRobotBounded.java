package leetcode;

/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 *
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 *
 * 只有在平面中存在圆使得机器人永远无法离开圆时，返回 true。否则，返回 false。
 *
 *
 * 示例 1：
 *
 * 输入："GGLLGG"
 * 输出：true
 * 解释：
 * 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
 * 重复指令时，机器人将保持在以原点为中心，2 为半径的圆中。
 *
 *
 * 示例 2：
 *
 * 输入："GG"
 * 输出：false
 * 解释：
 * 机器人无限向北移动。
 *
 *
 * 示例 3：
 *
 * 输入："GL"
 * 输出：true
 * 解释：
 * 机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。
 */

public class N1041isRobotBounded {

    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < instructions.length(); j++){
                char c= instructions.charAt(j);
                if (c == 'G'){
                    x += dx[d];
                    y += dy[d];
                }else if (c == 'L'){
                    d = (d + 3) % 4;
                }else if (c == 'R'){
                    d = (d + 1) % 4;
                }
            }
        }

        return x == 0 && y == 0;
    }
}
