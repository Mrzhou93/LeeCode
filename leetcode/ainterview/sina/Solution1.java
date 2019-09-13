package leetcode.ainterview.sina;

import java.util.Scanner;


public class Solution1 {
    public String getMinVersion(String[] list) {
        // 在这里编写代码
        String[] ans = list[0].split("\\.");

        for (String s: list){
            String[] ss = s.split("\\.");

            int minLength = ans.length < ss.length? ans.length: ss.length;
            for (int n = 0; n < minLength; n++){
                if (Integer.valueOf(ss[n]) < Integer.valueOf(ans[n])){
                    ans = ss;
                } else if (Integer.valueOf(ss[n]) > Integer.valueOf(ans[n])){
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < ans.length; i++){
            sb.append(ans[i]).append(".");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String s = sc.nextLine();
            if (s.equals("EOF"))
                break;
            String[] nums = s.split(",");
            System.out.println(solution.getMinVersion(nums));
        }
    }
}