package src;

class NrotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            length++;
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
        }
        tail.next = head;
        int n = k % length;
        for (int i = 0; i < length - n; i++) {
            tail = tail.next;
        }
        cur = tail.next;
        tail.next = null;
        return cur;
    }

    private ListNode reverse(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
