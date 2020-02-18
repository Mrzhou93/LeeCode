package leetcode.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法，add和size，写两个线程，
 * 线程1添加10个元素到容器，
 * 线程2实现监控元素个数，当个数为5个时，线程2给出提示并结束线程2。
 */

public class MiContainer {
    private List list = new ArrayList();
    boolean printInfo = true;

    public void add(Object obj) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            synchronized (list) {
                while (printInfo){
                    list.wait();
                }
                list.add(obj);
                System.out.println("向Container中添加一个元素");
                if (list.size() % 5 == 0){
                    printInfo = true;
                }

                list.notifyAll();
            }
        }
    }

    public void size() throws InterruptedException {
        for (int i = 0; i < 2; i++){
            synchronized (list){
                while (!printInfo){
                    list.wait();
                }
                System.out.println(list.size());
                System.out.println("添加了5个元素");
                printInfo = false;
                list.notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        MiContainer container = new MiContainer();

        new Thread(() -> {
            try {
                container.add(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                container.size();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
