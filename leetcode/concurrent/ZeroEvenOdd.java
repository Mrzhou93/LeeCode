package leetcode.concurrent;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class IntConsumer{
    public void accept(int x){
        System.out.print(x);
    }
}

public class ZeroEvenOdd {
    private int n;
    private final Object object = new Object();
    private boolean isPrintZero;
    private int currentNum;

    public ZeroEvenOdd(int n) {
        this.n = n;
        isPrintZero = true;
        currentNum = 1;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                while (!isPrintZero) {
                    object.wait();
                }
                printNumber.accept(0);
                isPrintZero = false;
                object.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n - (n / 2); i++) {
            synchronized (object) {
                while (isPrintZero || currentNum % 2 == 0) {
                    object.wait();
                }
                printNumber.accept(currentNum++);
                isPrintZero = true;

                object.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            synchronized (object) {
                while (isPrintZero || currentNum % 2 == 1) {
                    object.wait();
                }
                printNumber.accept(currentNum++);
                isPrintZero = true;

                object.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntConsumer ic = new IntConsumer();
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            ZeroEvenOdd s = new ZeroEvenOdd(n);

            ExecutorService executors = Executors.newFixedThreadPool(3);

            executors.execute(
            new Thread(()->{
                try {
                    s.zero(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));

            executors.execute(
            new Thread(()->{
                try {
                    s.even(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));

            executors.execute(
            new Thread(()->{
                try {
                    s.odd(ic);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
