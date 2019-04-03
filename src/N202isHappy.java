package src;

import java.util.HashSet;
import java.util.Set;

class N202isHappy {
    public boolean isHappy(int n) {
        Set<Integer> HashSet =  new HashSet<>();
        int sum;
        HashSet.add(n);

        while(n!=1){
            sum = 0;

            while(n!=0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }

            if (HashSet.contains(sum))
                return false;

            if (sum != 1)
                HashSet.add(sum);

            n = sum;

        }

        return true;
    }

    public static void main(String[] args){

        N202isHappy s = new N202isHappy();

        System.out.println(s.isHappy(2));
    }

}
