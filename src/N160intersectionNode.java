package src;

import java.util.HashSet;
import java.util.Set;

class N160intersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSeed = new HashSet<>();

        while(headA != null){
            nodeSeed.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if (nodeSeed.contains(headB))
                return headB;
            else
                headB = headB.next;
        }
        return null;
    }
}
