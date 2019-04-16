package src;

/**
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
 *
 * 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。
 * 如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：source = "abc", target = "abcbc"
 * 输出：2
 * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
 * 示例 2：
 *
 * 输入：source = "abc", target = "acdbc"
 * 输出：-1
 * 解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
 * 示例 3：
 *
 * 输入：source = "xyz", target = "xzyxz"
 * 输出：3
 * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
 * */

class NnumverOfSubString{

    int j;  // target的指针

    public int numverOfSubString(String source, String target){
        j = 0;
        int result = 0;
        boolean flag = true;
        while (flag){
            flag = find(source, target);
            if (flag)
                result++;
        }
        return j == target.length() && result != 0? result: -1;
    }

    private boolean find(String source, String target){
        int i = 0;
        boolean flag = false;

        while (i < source.length() && j < target.length()){
            if (source.charAt(i) == target.charAt(j)){
                i++;
                j++;
                flag = true;
            }else {
                i++;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        NnumverOfSubString s = new NnumverOfSubString();

        System.out.println(s.numverOfSubString("abc", "abcbc"));
        System.out.println(s.numverOfSubString("abc", "acdbc"));
        System.out.println(s.numverOfSubString("xyz", "xzyxz"));
        System.out.println(s.numverOfSubString("", "xzyxz"));
        System.out.println(s.numverOfSubString("xyzxyz", ""));
    }
}