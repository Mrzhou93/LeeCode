package leetcode;

class N28strStr {
    public int strStrBF(String haystack, String needle) {
        int i=0, j=0;
        while (i < haystack.length() && j<needle.length()){
            if (haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= needle.length()){
            return i - needle.length();
        }
        return -1;
    }

    private void findMax(String needle, int[] next){
        int j = 0, k = -1;
        next[0] = -1;
        while (j < needle.length() - 1){
            if (k==-1 || needle.charAt(k) == needle.charAt(j)){
                j++;
                k++;
                if (needle.charAt(j) != needle.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            }
            else{
                k = next[k];
            }
        }
    }

    public int strStr(String haystack, String needle){
        if (needle.length() == 0)
            return 0;

        int i = 0, j =0;
        int[] next = new int[needle.length()];

        findMax(needle, next);
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if (j >= needle.length())
            return i-needle.length();
        else
            return -1;
    }

    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "ll";
        String s3 = "";

        N28strStr s = new N28strStr();
        System.out.println(s.strStr(s1, s2));
        System.out.println(s.strStr(s1, s3));
    }
}
