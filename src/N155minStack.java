package src;

import java.util.ArrayList;
import java.util.List;

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
