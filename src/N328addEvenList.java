package src;

class NaddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next == null)
            return head;

        ListNode endOfOdd = head;
        ListNode endOfEven = head.next;
        ListNode startOfEven = endOfEven;

        while(endOfOdd.next != null && endOfEven.next != null){
            endOfOdd.next = endOfEven.next;
            endOfOdd = endOfOdd.next;
            endOfEven.next = endOfOdd.next;
            endOfEven = endOfEven.next;
        }
        endOfOdd.next = startOfEven;
        return head;
    }
}
