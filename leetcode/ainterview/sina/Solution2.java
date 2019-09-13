package leetcode.ainterview.sina;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution2 extends LinkedHashMap<Integer, Integer> {
    private int cap;

    public Solution2(int capacity) {
        super(capacity);
        this.cap = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() >= cap;
    }
}
