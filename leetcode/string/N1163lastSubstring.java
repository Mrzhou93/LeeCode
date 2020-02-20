package leetcode.string;

public class N1163lastSubstring {
    public String lastSubstring(String s) {
        int ans = 0;
        int len = s.length();

        for (int i = 1; i < len; i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                while (i + 1 < len && s.charAt(i + 1) == s.charAt(i - 1)){
                    i++;
                }
            }
            if (large(s, i, ans)){
                ans = i;
            }
        }
        return s.substring(ans);
    }

    public boolean large(String s, int i, int j){
        int len = s.length();
        while (i < len && j < len){
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j++;
            } else {
                return s.charAt(i) > s.charAt(j);
            }
        }
        return i < j;
    }

    public static void main(String[] args) {
        N1163lastSubstring s = new N1163lastSubstring();

        System.out.println(s.lastSubstring("abab"));
        System.out.println(s.lastSubstring("leetcode"));
        System.out.println(s.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));
    }
}
