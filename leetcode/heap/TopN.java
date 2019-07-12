package leetcode.heap;

public class TopN {

    private int parent(int n){
        return (n - 1) / 2;
    }

    private int left(int n){
        return 2 * n + 1;
    }

    private int right(int n){
        return 2 * n + 2;
    }

    private void buildHeap(int n, int[] data){
        for (int i = 1; i < n; i++){
            int t = i;

            while (t != 0 && data[parent(t)] > data[t]){
                int tmp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = tmp;
                t = parent(t);
            }
        }
    }

}
