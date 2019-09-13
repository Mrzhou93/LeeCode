package leetcode.ainterview.ctrip;

/**
 * 表达式解析
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 豚厂给自研的数据库设计了一套查询表达式，在这个表达式中括号表示将里面的字符串翻转。请你帮助实现这一逻辑
 *
 * 输入
 * 一行字符串
 *
 * 输出
 * 一行字符串
 *
 * 如果表达式括号不匹配，输出空字符串
 *
 *
 * 样例输入
 * ((ur)oi)
 * 样例输出
 * iour
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++){
            if (expr.charAt(i) == ')'){
                StringBuffer sb = new StringBuffer();
                while (stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int j = 0; j < sb.length(); j++){
                    stack.push(sb.charAt(j));
                }
            } else {
                stack.push(expr.charAt(i));
            }
        }

        StringBuffer ans = new StringBuffer();

        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();

//        for (int i = 0; i < a.length; i++){
//            ans.append((char) a[i]);
//        }
//        System.out.println(stack);
////        System.out.println(Arrays.toString(stack.toArray()));

        return ans.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

