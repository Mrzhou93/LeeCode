package leetcode.ainterview.sf;

/**
 * 特殊计时
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 24小时计时制是一个广为使用的计时体系。但是不同地方使用的计数进制是不同的，例如，在一个古老的村庄就是使用二进制下的24小时制，这时“11：11”表示的就是3点03分。
 *
 * 现在给出一个未知的时刻，用形如“a:b”的形式来表示，a，b分别是一个字符串，字符串可以由0-9和A-Z组成，分别代表0-9和10-35。请你求出这个时刻所处的所有可能的进制。
 *
 * 输入
 * 输入仅包含一行，即a:b的形式，a，b的含义及组成如题面所示
 *
 * 输出
 * 输出可以包含若干个整数，如果不存在任何一个进制符合要求，则输出“-1”，如果有无穷多的进制数符合条件，则输出“0”，否则按从小到大的顺序输出所有进制数，中间用空格隔开
 *
 *
 * 样例输入
 * 00002:00130
 * 样例输出
 * 4 5 6
 */

public class Main1 {
    public void f(String str){
        String[] s = str.split(":");
        StringBuilder hour = new StringBuilder();
        StringBuilder min = new StringBuilder();

        for (int i = 0; i < s[0].length(); i++){
            if (s[0].charAt(i) >= '0' && s[0].charAt(i) <= '9'){
                hour.append(s[0].charAt(i));
            } else {
                hour.append(s[0].charAt(i) - 'a' + 10);
            }
        }

        for (int i = 0; i < s[1].length(); i++){
            if (s[1].charAt(i) >= '0' && s[1].charAt(i) <= '9'){
                min.append(s[1].charAt(i));
            } else {
                min.append(s[1].charAt(i) - 'a' + 10);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < hour.length(); i++){
            max = Math.max(max, Integer.valueOf(hour.charAt(i)));
        }
        for (int i = 0; i < min.length(); i++){
            max = Math.max(max, Integer.valueOf(min.charAt(i)));
        }
    }

    public static void main(String[] args) {
        Main1 s = new Main1();

    }
}
