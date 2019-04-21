package leetcode;

class N19removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        ListNode start = new ListNode(0);
        start.next = head;

        ListNode fast = start;
        ListNode slow = start;

        for (int j=0; j < n; j++){
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
