package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */

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
