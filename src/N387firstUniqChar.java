package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class N387firstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> hashMap = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                hashMap.add(s.charAt(i));
            else {
                map.put(s.charAt(i), i);
            }
        }

        for (int i = 0; i<s.length(); i++){
            if (!hashMap.contains(s.charAt(i)))
                return map.get(s.charAt(i));
        }
        return -1;
    }
}
