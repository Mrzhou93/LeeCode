package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};

class N430flatten {
    public Node flatten(Node head) {

        Stack<Node> NextToVisit = new Stack<>();
        Node cur = head;
        Node dummy = new Node(-1, null, head, null);

        while(cur != null){
            if (cur.child != null) {
                if (cur.next != null)
                    NextToVisit.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }else {
                if (cur.next == null && !NextToVisit.empty()) {
                    cur.next = NextToVisit.pop();
                    cur.next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

// {"$id":"1","child":null,
//      "next":{"$id":"2","child":null,
//          "next":{"$id":"3","child":null,
//              "next":{"$id":"4","child":null,
//                  "next":{"$id":"5","child":null,
//                      "next":{"$id":"6","child":null,
//                          "next":{"$id":"7","child":null,
//                              "next":{"$id":"8","child":null,
//                                  "next":{"$id":"9","child":null,
//                                      "next":{"$id":"10","child":null,
//                                          "next":{"$id":"11","child":null,
//                                              "next":{"$id":"12","child":null,
//                                                  "next":null,"prev":{"$ref":"11"},"val":6},"prev":{"$ref":"10"},"val":5},"prev":{"$ref":"9"},"val":4},"prev":{"$ref":"8"},"val":10},"prev":{"$ref":"7"},"val":9},"prev":{"$ref":"6"},"val":12},"prev":{"$ref":"5"},"val":11},"prev":{"$ref":"4"},"val":8},"prev":{"$ref":"3"},"val":7},"prev":{"$ref":"2"},"val":3},"prev":{"$ref":"1"},"val":2},"prev":null,"val":1}