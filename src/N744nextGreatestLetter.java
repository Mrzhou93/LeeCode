package src;

class N744nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z')
            return letters[0];

        int left = 0, right = letters.length - 1;
        int mid = 0;

        while (left < right){       // 找到target的位置，因为target可能有多个重复的元素
            mid = left + (right - left) / 2;

            if (letters[mid] == target)
                break;
            else if (letters[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        while (letters[mid] <= target && mid < letters.length - 1){
            mid++;
        }

        if (mid == letters.length - 1 && letters[mid] <= target)
            mid = 0;
        return letters[mid];
    }

    public static void main(String[] args){
        char[] letters = {'c', 'f', 'j'};
        char[] letters1 = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        N744nextGreatestLetter s = new N744nextGreatestLetter();
        System.out.println(s.nextGreatestLetter(letters, 'a'));     // c
        System.out.println(s.nextGreatestLetter(letters1, 'f'));    // n
        System.out.println(s.nextGreatestLetter(letters1, 'n'));    // e
        System.out.println(s.nextGreatestLetter(letters, 'd'));     // f
        System.out.println(s.nextGreatestLetter(letters, 'k'));     // c
    }
}
