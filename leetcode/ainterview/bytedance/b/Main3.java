package leetcode.ainterview.bytedance.b;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {

    public int maxScore(Deque<Integer> deque){
        int ans = 0;

        while (!deque.isEmpty()){
            if (deque.peekFirst() > deque.peekLast()){
                ans += deque.pollFirst();
            } else {
                ans += deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() > deque.peekLast()){
                deque.pollFirst();
            } else if (!deque.isEmpty() && deque.peekFirst() <= deque.peekLast()){
                deque.pollLast();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Main3 main = new Main3();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            Deque<Integer> deque = new LinkedList();

            for (int i = 0; i < n; i++){
                deque.addLast(sc.nextInt());
            }
//            System.out.println(deque);

            System.out.println(main.maxScore(deque));
        }
    }
}
