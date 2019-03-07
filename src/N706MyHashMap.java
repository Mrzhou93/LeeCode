package src;

class MyHashMap {
    private Integer[] myHashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myHashMap = new Integer[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        myHashMap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (myHashMap[key] != null)
            return myHashMap[key];
        else
            return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        myHashMap[key] = null;
    }
}
