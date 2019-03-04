package src;

import java.util.Arrays;

class N66PlusOne {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;

        if (digits[i] != 9){
            digits[i]++;
            return digits;
        }

        boolean flag=true;

        while (i>=0 && flag){
            digits[i--] = 0;
            if (i>=0 && digits[i] !=9 ) {
                digits[i]++;
                flag = false;
            } else if(i<0){
                int[] newdigits = new int[digits.length+1];
                newdigits[0]=1;
                for (int j=0; j<digits.length ;j++){
                    newdigits[j+1] = digits[j];
                }
                return newdigits;
            }

        }
        return digits;
    }

    public static void main(String[] args){
        int[] num = {1, 2, 3};
        int[] num1 = {4, 3, 2, 1};
        int[] num2 = {9};
        int[] num3 = {3, 2, 9};

        N66PlusOne s = new N66PlusOne();

        int[] result = s.plusOne(num);
        int[] result1 = s.plusOne(num1);
        int[] result2 = s.plusOne(num2);
        int[] result3 = s.plusOne(num3);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}
