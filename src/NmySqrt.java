package src;

public class NmySqrt {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;

        int r = x;

        while(r > x / r){
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args){
        NmySqrt s = new NmySqrt();
        System.out.println(s.mySqrt(9));    // 3
        System.out.println(s.mySqrt(8));    // 2
        System.out.println(s.mySqrt(0));    // 0
        System.out.println(s.mySqrt(1));    // 1
        System.out.println(s.mySqrt(2147483647));    // 1

    }
}
