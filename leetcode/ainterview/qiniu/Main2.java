package leetcode.ainterview.qiniu;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public int isRight(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{' || c == '<'){
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else if (c == '>' && !stack.isEmpty() && stack.peek() == '<'){
                stack.pop();
            } else {
                return 0;
            }
        }
        return stack.isEmpty()? 1: 0;
    }

    public static void main(String[] args) {
        Main2 s = new Main2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(s.isRight(str));
        }
    }
}
