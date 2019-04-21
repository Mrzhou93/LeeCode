package leetcode;

class N1013numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int i, j, res = 0;
        for (i = 0; i< time.length; i++){
            for (j = i; j < time.length; j++){
                if (i < j && (time[i] + time[j]) % 60 == 0)
                    res++;
            }
        }
        return res;
    }


    public static void main(String[] args){
        N1013numPairsDivisibleBy60 s = new N1013numPairsDivisibleBy60();
        int[] num = {30,20,150,100,40};
        int[] num1 = {60, 60, 60};
        int[] num2 = {30};
        int[] num3 = {120};

        System.out.println(s.numPairsDivisibleBy60(num));
        System.out.println(s.numPairsDivisibleBy60(num1));
        System.out.println(s.numPairsDivisibleBy60(num2));
        System.out.println(s.numPairsDivisibleBy60(num3));
    }
}
