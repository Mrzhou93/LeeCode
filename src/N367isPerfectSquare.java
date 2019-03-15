package src;

class NisPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;

        while (left <= right){
            int mid = left + (right - left) / 2;
            double cal = mid * 1.0 * mid;

//            System.out.println("    "+cal);

            if (cal == num)
                return true;
            else if (cal < num)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args){
        NisPerfectSquare s = new NisPerfectSquare();
        System.out.println(s.isPerfectSquare(16));
        System.out.println(s.isPerfectSquare(14));
        System.out.println(s.isPerfectSquare(2147483647));
    }
}
