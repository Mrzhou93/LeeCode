package src;
class N344reverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while(i < j){
            reverse(s, i , j);
            i++;
            j--;
        }
    }

    private void reverse(char[] s, int i, int j){
        char temp;
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
