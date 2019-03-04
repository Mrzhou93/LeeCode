package src;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {  // N225ImplementStackUsingQueues

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = queue.peek();

        for (int i=0; i<queue.size(); i++){
            result = queue.remove();

            if(i!=queue.size()) {
                queue.add(result);
            }
        }
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = queue.peek();

        for (int j=0; j<queue.size(); j++){
            result = queue.remove();
            queue.add(result);
        }

        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }

    private void print(){

        System.out.println(queue);

    }


    public static void main(String[] arg){
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println("    "+stack.size());
        stack.print();
        System.out.println(stack.pop());
        System.out.println("    "+stack.size());
        stack.print();
        System.out.println(stack.empty());
    }
}
