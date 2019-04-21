package leetcode;

import java.util.Stack;

class N232ImplementQueuesUsingStack {  //

    private Stack<Integer> stack = new Stack<>();

    /** Initialize your data structure here. */
    public N232ImplementQueuesUsingStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();

        while (!empty()){
            tempStack.push(stack.pop());
        }

        int result = tempStack.pop();

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();

        while (!empty()){
            tempStack.push(stack.pop());
        }

        int result = tempStack.peek();

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
