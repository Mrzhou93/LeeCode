package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class N394DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i=0; i< s.length(); i++){

            char current = s.charAt(i);
            if (current != ']') {

                stack.push(current);
            } else {
                Queue<Character> queue = new LinkedList<>();

                int num;
                boolean flag=true;

                while(!stack.isEmpty() && flag){
                    char topChar = stack.peek();

                    if (topChar != '['){
                        queue.add(topChar);
                        stack.pop();
                    } else{
                        flag = false;
                        stack.pop();
                        num = Integer.parseInt(stack.pop().toString());

                        for (int j =0 ;j<num; j++){
                            for (int n=0; n<queue.size();n++){
                                char frontQueue = queue.remove();
                                stack.push(frontQueue);
                                queue.add(frontQueue);
                            }
                        }
                    }
                }
            }
        }
        return stack.toString();
    }

    public static void main(String[] args){

        String st = "3[a]2[bc]";

        N394DecodeString s = new N394DecodeString();

        System.out.println(s.decodeString(st));

    }
}
