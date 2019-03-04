package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class N841KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        int[] visited= new int[rooms.size()];
        int count = 1;

        List<Integer> firstRoom = rooms.get(0);

        if (firstRoom == null)
            return false;

        visited[0] = 1;

        for (int i=0; i<firstRoom.size(); i++){
            stack.push(firstRoom.get(i));
        }

        while(!stack.isEmpty()){
            int topStack = stack.pop();

            if (visited[topStack] == 0){
                visited[topStack] = 1;
                count ++;

                List<Integer> currentRoom = rooms.get(topStack);
                for (int i=0;i< currentRoom.size(); i++){
                    stack.push(currentRoom.get(i));
                }
            }
        }
        if(count == rooms.size())
            return true;

        return false;
    }
}

