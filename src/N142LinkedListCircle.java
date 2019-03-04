package src;

class N142LinkedListCircle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != slow && fast!= null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
