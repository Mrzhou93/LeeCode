package leetcode.ainterview.yongyou;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int getSocre(int energy, int[] cards){
        int ans = 0;

        Arrays.sort(cards);
        int i = 0;
        int j = cards.length - 1;
        while (i < j){

            if (ans == 0){
                while (i < j && energy >= cards[i]){
                    energy -= cards[i];
                    i++;
                    ans++;
                }
            }

            while (i < j && ans > 0 && energy < cards[i]){
                // 尽可能多的获得能量
                energy += cards[j];
                j--;
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main s = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] sss = str.split("\\D");
            String energy = sss[5];
            int start;

            for (start = 6; start < sss.length; start++){
                if (sss[start].length() != 0) {
                    break;
                }
            }
            int size = sss.length - start;
            int[] cards = new int[size];
            for (int i = 0; i < size; i++){
                if ("A".equals(sss[start + i])){
                    cards[i] = 1;
                } else if ("J".equals(sss[start + i])){
                    cards[i] = 11;
                } else if ("Q".equals(sss[start + i])){
                    cards[i] = 12;
                }else if ("K".equals(sss[start + i])){
                    cards[i] = 13;
                } else {
                    cards[i] = Integer.valueOf(sss[start + i]);
                }
            }
            System.out.println(s.getSocre(Integer.valueOf(energy), cards));
        }
// "P = 10,V= [5,8,10,13]"
        // "P = 10,V= [13]"
    }
}
