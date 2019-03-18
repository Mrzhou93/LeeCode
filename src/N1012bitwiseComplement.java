package src;

class N1012bitwiseComplement {
    public int bitwiseComplement(int N) {
        if (N==0)
            return 0;
        int m = 1;
        while (m <= N){
            m *= 2;
        }
        m -= 1;

        return m ^ N;
    }

    public static void main(String[] args){
        N1012bitwiseComplement s = new N1012bitwiseComplement();
        System.out.println(s.bitwiseComplement(5));
        System.out.println(s.bitwiseComplement(7));
        System.out.println(s.bitwiseComplement(10));
        System.out.println(s.bitwiseComplement(0));
        System.out.println(s.bitwiseComplement(1));  //0
    }
}
