package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */

public class N378kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){

                System.out.println(matrix[i][j]);
                if (pq.size() < k){
                    pq.add(matrix[i][j]);
                }else if (matrix[i][j] < pq.peek()){
                    pq.remove();
                    pq.add(matrix[i][j]);
                }
            }
        }

        return pq.peek();
    }

    public static void main(String[] args){
        N378kthSmallest s= new N378kthSmallest();
        System.out.println(s.kthSmallest(new int[][]{{1, 5, 9},
                                                     {10, 11, 13},
                                                     {12, 13, 15}}, 8));
    }
}
