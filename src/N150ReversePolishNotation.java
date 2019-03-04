package src;

import java.util.Stack;

class N150ReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i< tokens.length; i++){
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if (tokens[i].equals("+")){
                    stack.push(num1+num2);
                }else if (tokens[i].equals("-")){
                    stack.push(num1-num2);
                }else if (tokens[i].equals("*")){
                    stack.push(num1 * num2);
                }else if (tokens[i].equals("/")){
                    int result = num1 / num2;
                    stack.push(result);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args){
        String[] tokens = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16",
                "/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+",
                "156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84",
                "+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/",
                "95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187",
                "-","143","/","-79","-89","+","-"};

        String[] tokens1 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] tokens2 = {"2","1","+","3","*"};
        N150ReversePolishNotation s = new N150ReversePolishNotation();
        int result = s.evalRPN(tokens2);
        System.out.println(result);
    }
}
