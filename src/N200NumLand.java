package src;

class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public int Size(){
        return (Math.abs(tail - head) % size) + 1 ;
    }

    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}

class numIslands {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int max = grid.length > grid[0].length? grid.length: grid[0].length;

        int min = grid.length < grid[0].length? grid.length: grid[0].length;

        int[] visited = new int[max];

        MyCircularQueue queue = new MyCircularQueue(max);

        int num = 0;

        for(int i=0; i < max; i++){

            // 当第i个元素被访问到
            if(i<min && visited[i]==0 && grid[i][i] == '1'){

                num += 1;

                queue.enQueue(i);
                visited[i] = 1;

                while (!queue.isEmpty()){

                    int current = queue.Front();

                    for(int m=0; m < grid.length; m++){
                        if(grid[m][current] == '1' && visited[m] == 0) {
                            queue.enQueue(m);
                            visited[m] = 1;
                        }
                    }

                    queue.deQueue();
                }

            }
        }
        return num;
    }

    public int numIslands1(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];

        int num=0;
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    num++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return num;
    }

    private void bfs(char[][] grid, int[][] visited, int row, int col){
        if(row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && visited[row][col] == 0 && grid[row][col] == '1'){

            visited[row][col] = 1;

            bfs(grid, visited, row-1, col);
            bfs(grid, visited, row+1, col);
            bfs(grid, visited, row, col+1);
            bfs(grid, visited, row, col-1);

        }
    }

    public static void main(String[] args){

        char[][] grid1 = {{'1','1','1','1','0'}, {'1','1','0','1','0'},
                {'1','1','0','0','0'}, {'0','0','0','0','0'}};

        char[][] grid2 = {{'1','1','0','0','0'}, {'1','1','0','0','0'},
                {'0','0','1','0','0'}, {'0','0','0','1','1'}};

        char[][] grid3 = {{'1','1','0','0','0'}, {'0','1','0','0','1'},
                {'0','0','0','1','1'}, {'0','0','0','0','0'}, {'0', '0', '0', '0', '1'}};

        numIslands s = new numIslands();

        System.out.println(s.numIslands1(grid1));
        System.out.println(s.numIslands1(grid2));
        System.out.println(s.numIslands1(grid3));
    }
}