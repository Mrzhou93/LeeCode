package leetcode.stack;
import leetcode.ListNode;

import java.util.*;

class N1019nextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> elements = new ArrayList<>();

        while(head != null){
            elements.add(head.val);
            head = head.next;
        }

        int[] result = new int[elements.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < elements.size(); i++){
            // 栈中存放的是比第i位要小的数的索引
            while(!stack.isEmpty() && elements.get(stack.peek()) < elements.get(i)){
                int t = stack.pop();
                result[t] = elements.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
