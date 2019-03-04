package src;

public class N151ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || "".equals(s.trim())){
            return "";
        }else{
            String [] strs = s.trim().split("\\s");
            int len = strs.length-1;
            for(int i=len;i>=0;i--){
                if(i == 0){
                    sb.append(strs[i]);
                }else{
                    sb.append(strs[i]+" ");
                }
            }
            return sb.toString();
        }
    }
}
