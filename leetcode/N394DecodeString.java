package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


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
