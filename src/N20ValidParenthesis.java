package src;

import java.util.Stack;

class N20ValidParenthesis {
    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){

            char tempChar = s.charAt(i);

            if ( tempChar=='(' || tempChar == '[' || tempChar == '{') {
                stack.push(tempChar);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.peek();
                if ((topChar == '(' && tempChar==')') || (topChar=='[' && tempChar == ']') ||
                        (topChar == '{' && tempChar == '}')){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args){
        String s1 = "(([]){})";
        String s2 = "[()]";
        String s3 = "{[)}";

        N20ValidParenthesis s = new N20ValidParenthesis();
        System.out.println(s.isValid(s1));
        System.out.println(s.isValid(s2));
        System.out.println(s.isValid(s3));
    }
}
