package leetcode.ainterview.shangtang;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public Long getAns(long n, long x){
        long ans = n;

        for (Long d = n; d > 0; d--){
            String changedValue = change(n, d);
            if ("wrong".equals(changedValue)){
                continue;
            }
            if (changedValue.length() > 18){
                continue;
            }
            if (Long.valueOf(changedValue) >= x){
                ans = d;
                break;
            }
        }
        return ans;
    }

    public String change(long num, long d){
        StringBuffer sb = new StringBuffer();
        Stack<Long> stack = new Stack<>();
        boolean is = true;
        while ((num / d) >= 1){
            long n = num % d;
            if (n >= 10){
                is = false;
                break;
            }
            stack.push(n);
            num /= d;
        }
        if (num != 0) {
            stack.push(num);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return !is? "wrong": sb.toString();
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()){
            long n = sc.nextLong();
            long x = sc.nextLong();

            System.out.println(s.getAns(n, x));
        }
    }
}
