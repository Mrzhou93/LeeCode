package leetcode.stack;


import java.util.*;

public class N71simplifyPath {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
//        System.out.println(Arrays.toString(str));

//        Stack<String> queue = new Stack<>();
        Deque<String> queue = new LinkedList<>();

        for (int i = 1; i < str.length; i++){
            if (!str[i].equals("") && !str[i].equals(".") && !str[i].equals("..")){
                queue.add(str[i]);
            } else if (str[i].equals("..") && !queue.isEmpty()){
                queue.removeLast();
            }
        }

//        System.out.println(queue);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            sb.append("/").append(queue.removeFirst());
        }

        return sb.length() == 0?"/": sb.toString();
    }

    public static void main(String[] args) {
        N71simplifyPath s = new N71simplifyPath();

        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(s.simplifyPath("/../"));
    }
}
