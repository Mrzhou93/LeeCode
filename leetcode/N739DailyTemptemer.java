package leetcode;

import java.util.Stack;

class N739DailyTemptemer {
    public int[] dailyTemperatures(int[] T) {

        if (T==null || T.length==0)
            return T;

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[T.length];

        for(int i=0; i<T.length; i++){

            if (!stack.isEmpty()){
                while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }

            stack.push(i);

        }
        return result;
    }


    public static void main(String[] args){
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        N739DailyTemptemer s = new N739DailyTemptemer();
        int[] result =  s.dailyTemperatures(temperatures);
        for (int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
