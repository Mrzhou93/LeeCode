//package src;
//import java.util.*;

//public class Main {
//    public int minCoin(int n, int m){  // n最大面额 m商品价格
//        if (n == 1)
//            return m;
//
//        if (m <= 0 || n <= 0)
//            return 0;
//
//        if (n > m )
//            return 1;
//        System.out.println("    "+m);
//        return minCoin(n, m-n) + 1;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        Main s = new Main();
//
////        System.out.println(s.minCoin(6, 7));
//        System.out.println(s.minCoin(1, 5));
//
//
//        while (sc.hasNextInt()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            System.out.println(s.minCoin(a, b));
//        }
//    }
//}

//public class Main {
//    public int targetSum(int left, int right){
//        if (left == right){
//            return left % 2 == 0 ? left: -left;
//        }
//        boolean lefto, righto;
//        lefto = (left % 2) == 0;
//        righto = (right % 2) == 0;
//
//        if (lefto && righto)
//            return right - (right - left) / 2;
//        if (!lefto && !righto)
//            return (right - left) / 2 - right;
//        if (lefto && !righto)
//            return -((right + 1 - left) / 2);
//        if (!lefto && righto)
//            return (right + 1 - left) / 2;
//        return 0;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        Main s = new Main();
//
//        System.out.println(s.targetSum(2, 4));
//        System.out.println(s.targetSum(2, 2));
//        System.out.println(s.targetSum(3, 3));
//        System.out.println(s.targetSum(1, 5));
//
//        int times = sc.nextInt();
//        while (times > 0){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            System.out.println(s.targetSum(a, b));
//            times--;
//        }
//    }
//}

//public class Main {
//    public int sum(int n, int s){
//        if (n < s)
//            return 0;
//
//        if (n == s)
//            return 1;
//
//        return (cal(n, s) / cal(s, 1)) + n;
//    }
//
//    private int cal(int m, int n){
//        if (m == n)
//            return m;
//
//        return m * cal(m-1, n);
//    }
//
//    public static void main(String[] args){
//        Main so = new Main();
//
//        Scanner sc = new Scanner(System.in);
//
////        System.out.println(so.cal(5, 2));
////        System.out.println(so.cal(5, 3));
////        System.out.println(so.cal(6, 2));
//
//        System.out.println(so.sum(3, 2));
//
////        System.out.println(so.sum(5, 3));
//
//        while(sc.hasNextInt()){
//            int n = sc.nextInt();
//            int s = sc.nextInt();
//            int temp;
//            for (int i=0; i< n; i++){
//                temp = sc.nextInt();
//            }
//            System.out.println(so.sum(n, s));
//        }
//    }
//}

//public class Main {
//    public int sum(int n, int m, int[] nums){
//        Map<Integer, Integer> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
//
//        for (int i= 0; i < nums.length; i++){
//            set.add(nums[i]);
//        }
//
//        for (int i=1; i<=m; i++){
//            if (!set.contains(i))
//                return -1;
//        }
//
//        return 0;
//    }
//
//        public static void main(String[] args){
//        Main so = new Main();
//
//        Scanner sc = new Scanner(System.in);
//
//        int[] num1 = {2, 5, 3, 1, 3,2,4,1,0,5,4,3};
//        System.out.println(so.sum(3, 2, num1));
//
//
//        while(sc.hasNextInt()){
//            int n = sc.nextInt();
//            int s = sc.nextInt();
//            int[] num = new int[n];
//            for (int i=0; i< n; i++){
//                num[i] = sc.nextInt();
//            }
//            System.out.println(so.sum(n, s, num));
//        }
//    }
//}