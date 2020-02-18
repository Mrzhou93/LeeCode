package leetcode.ainterview.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    private String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans;
    public void combination(String digits){
         ans = new ArrayList<>();

        backTracing(digits, "");

        System.out.print("[");
        for (int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i));
            if(i != ans.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    private void backTracing(String digits, String s){
        if (digits.isEmpty()){
            if (!s.isEmpty()){
                ans.add(s);
            }
            return;
        }

        int i = digits.charAt(0) - '0';
        for (char c: dict[i].toCharArray()){
            backTracing(digits.substring(1), s + c);
        }
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String dig = sc.nextLine();
            s.combination(dig);
        }
    }
}
