package src;

class MyHashSet {

    private int[] myHashSet = new int[1000000];

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        myHashSet[key] = 1;
    }

    public void remove(int key) {
        myHashSet[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return myHashSet[key] == 1;
    }
}
