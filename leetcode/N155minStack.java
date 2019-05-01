package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

class N155minStack {

    private List<Integer> data;

    public N155minStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        if(!isEmpty())
            data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int getMin() {
        N155minStack tStack = new  N155minStack();
        int min = top();

        while( !isEmpty()){
            if (min > top()) {
                min = top();
            }

            tStack.push(top());
            pop();
        }

        while(!tStack.isEmpty()){
            push(tStack.top());
            tStack.pop();
        }

        return min;
    }

    public static void main(String[] args){

        N155minStack minStack = new  N155minStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

//        System.out.println(minStack.top());
//        System.out.println(minStack.isEmpty());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.isEmpty());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.isEmpty());
//        minStack.pop();
//        System.out.println(minStack.isEmpty());

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
