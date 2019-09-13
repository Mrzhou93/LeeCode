package leetcode.ainterview.ctrip;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一个单向链表和一个整数m，将链表中小于等于m的节点移到大于m的节点之前，要求两部分中的节点各自保持原有的先后顺序
 *
 * 输入
 * 输入数据包含两行，
 *
 * 第一行，整数m
 *
 * 第二行，空格分隔的整数序列
 *
 * 输出
 * 逗号分隔的整数序列
 *
 *
 * 样例输入
 * 4
 * 9 6 3 7 6 5
 * 样例输出
 * 3,9,6,7,6,5
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

public class Main1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        ListNode front = ans;

        while (cur.next != null){
            if (cur.next.val <= m){
                ListNode move = cur.next;
                cur.next = cur.next.next;
                move.next = head;
                front.next = move;
                front = move;
            }
            cur = cur.next;
        }

        return ans.next;
    }
    /******************************结束写代码******************************/
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}

