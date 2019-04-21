package leetcode;

class N206reverseList {
    public ListNode reverseList(ListNode head) {
        if (head== null)
            return null;

        ListNode first = head;  // 原始链的最开始的节点
        ListNode cur;           // 当前需要移动到最前的Node

        while(first.next != null){
            cur = first.next;
            first.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
