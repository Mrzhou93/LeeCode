package leetcode.ainterview.mi;

/**
 * 打印二叉树
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 在某个存储介质以如下形式保存一棵二叉树
 *
 * 1(2(3,4(,5)),6(7,))
 *
 * 上述序列表示的二叉树如下
 *
 *
 *
 * 观察后可以发现，每个节点的格式为
 *
 * X，X可以为空
 *
 * 或者
 *
 * X(Y, Z)，其中X不为空
 *
 * 请编写程序将以上述格式输入的二叉树输出为中序遍历顺序
 *
 * 输入
 * 上述格式表示的二叉树字符串，用字符1~9表示每个二叉树的每个节点，字符可以重复使用
 *
 * 输出
 * 二叉树的中序遍历结果
 *
 *
 * 样例输入
 * 1(2(3,4(,5)),6(7,))
 * 样例输出
 * 3245176
 */
import java.util.Scanner;
import java.util.Stack;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean conti = false;

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ','){
                sb.append(stack.pop());
            } else if (input.charAt(i) == '('){
                conti = true;
            } else if (conti){
                sb.append(stack.pop());
                conti = false;
            }
        }
        return sb.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        System.out.println(solution("1(2(3,4(,5)),6(7,)))"));

        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
