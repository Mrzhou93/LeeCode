package leetcode;


import java.util.LinkedList;
import java.util.Queue;

class N279PerfectSquare {

    private int bfs(int n){
        if (n == 0)
            return 0;

        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[n];

        queue.add(0);

        visited[0] = 1;

        int step = 0;

        while(!queue.isEmpty()){
//            System.out.println("step" + step);
            step ++;
            int size = queue.size();
//            System.out.println("    size"+size);

            for (int i = 0; i< size; i++){
                int current = queue.peek();
//                System.out.println("        current"+current);
                for (int j = 1; ; j++){
                    int total = current + j * j;

                    if(total > n)
                        break;
                    else if (total == n)
                        return step;

                    if(visited[total] == 0){
                        visited[total] = 1;
                        queue.offer(total);
                    }
                }
                queue.remove();
            }
        }
        return -1;
    }

    public static void main(String[] args){
        N279PerfectSquare s = new N279PerfectSquare();

        System.out.println(s.bfs(12));
    }
}
