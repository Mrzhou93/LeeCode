package leetcode.ainterview.yy;

import java.util.Scanner;

/**
 * @author MrZhou
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] strings = str.split(",");
            System.out.println(strings[0].matches(strings[1]));
        }
    }
}
