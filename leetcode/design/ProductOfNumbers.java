package leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 *
 * 1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 *
 *
 * 提示：
 *
 * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
 * 0 <= num <= 100
 * 1 <= k <= 40000
 */

public class ProductOfNumbers {

    private List<Integer> list;
    private int zeroIndex;
    private int curProduct;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        zeroIndex = -1;
        curProduct = 1;
    }

    public void add(int num) {
        curProduct *= num;
        list.add(curProduct);
        if (curProduct == 0){
            zeroIndex = list.size() - 1;
            curProduct = 1;
        }

    }

    public int getProduct(int k) {
        int index = list.size() - k;
//        System.out.println("Index=" + index);
        if (zeroIndex > index - 1 && zeroIndex != -1){
            return 0;
        }
        if (index == 0){
            return list.get(list.size() - 1);
        }

        return list.get(index - 1) == 0? list.get(list.size() - 1):
                list.get(list.size() - 1) / list.get(index - 1);
    }

    public void printAll(){
        System.out.println("maxZero=" + zeroIndex);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);        // [3]
        productOfNumbers.add(1);        // [3]
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.printAll();
        System.out.println(productOfNumbers.getProduct(2));
        // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3));
        // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4));
        // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2));
        // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
        System.out.println(productOfNumbers.getProduct(7));

        System.out.println("=============");
        ProductOfNumbers p2 = new ProductOfNumbers();
        p2.add(7);
        System.out.println(p2.getProduct(1)); // 7
        System.out.println(p2.getProduct(1)); // 7
        p2.add(4);
        p2.add(5);
//        p2.printAll();
        System.out.println(p2.getProduct(3)); // 140
        p2.add(4);
//        p2.printAll();
        System.out.println(p2.getProduct(4)); // 560
        p2.add(3);
//        p2.printAll();
        System.out.println(p2.getProduct(4)); // 240
        p2.add(8);
//        p2.printAll();
        System.out.println(p2.getProduct(1));  // 8
        System.out.println(p2.getProduct(6));  // 13440
        p2.add(2);
//        p2.printAll();
        System.out.println(p2.getProduct(3));  // 48



    }
}
