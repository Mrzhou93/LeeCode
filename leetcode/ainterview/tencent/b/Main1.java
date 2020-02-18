package leetcode.ainterview.tencent.b;
import java.util.Scanner;

public class Main1 {

    public String isPhoneNum(String str, int len){
        if (len < 11){
            return "NO";
        }

        int i = 0;
        for (; i < str.length(); i++){
            if (str.charAt(i) == '8'){
                break;
            }
        }

        int n = len - i;

        return str.length() - i >= 11? "YES": "NO";
    }

    public static void main(String[] args) {
        Main1 s = new Main1();
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        for (int i = 0 ; i < n; i++){
            int len = Integer.valueOf(sc.nextLine());
            String phone = sc.nextLine();
            System.out.println(s.isPhoneNum(phone, len));
        }
    }
}