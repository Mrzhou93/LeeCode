package leetcode.unionfind;

import java.util.Arrays;

/**
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 *
 * 示例 4：
 *
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 *
 * 示例 5：
 *
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 30
 * 2 grid[i][j] 是 '/'、'\'、或 ' '。

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class N959regionBySlashes {

    private int[] parent;

    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        parent = new int[length * length * 4];

        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                int start = (i * length + j) * 4;
                if (grid[i].charAt(j) == '\\'){
                    union(start, start + 1);
                    union(start + 2, start + 3);
                } else if (grid[i].charAt(j) == '/'){
                    union(start, start + 3);
                    union(start + 1, start + 2);
                } else {
                    union(start, start + 1);
                    union(start, start + 2);
                    union(start, start + 3);
                }

                if (i > 0){
                    union(start, start - 4 * length + 2);
                }
                if (j > 0){
                    union(start + 3, start - 3);
                }
            }
        }

//        System.out.println(Arrays.toString(parent));

        int ans = 0;
        for (int i = 0; i < parent.length; i++){
            if (i == parent[i]){
                ans++;
            }
        }

        return ans;
    }

    public void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if (rx != ry){
            parent[ry] = rx;
        }
    }

    public int find(int x){
        int r = x;
        while (r != parent[r]){
            r = parent[r];
        }

        return r;
    }

    public static void main(String[] args){
        N959regionBySlashes s = new N959regionBySlashes();

        System.out.println(s.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(s.regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(s.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(s.regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(s.regionsBySlashes(new String[]{"//", "/ "}));
    }
}
