package src;

import java.util.HashMap;
import java.util.Map;

class Nissomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 1; i<s.length(); i++){
            if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i))
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s1 = "aaadfg";

        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i<s1.length(); i++){
            map1.put(s1.charAt(i), i);
        }

        System.out.println(map1);

        Nissomorphic s = new Nissomorphic();

    }
}
