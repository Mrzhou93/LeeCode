package leetcode.ainterview.huawei.a;

import java.util.Scanner;

/**
 * @author MrZhou
 */
public class Main2 {
    public void findAns(String str){
        String[] string = "[^A-Za-z0-9\\-{2,}]".split(str);

        for (int i = string.length - 1; i >= 0; i--){
            System.out.print(string[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Main2 s = new Main2();

        Scanner sc= new Scanner(System.in);

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            s.findAns(str);
        }
    }
}
