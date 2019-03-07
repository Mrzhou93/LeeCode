package src;

class NaddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curInsert = dummy;
        ListNode curl1 = l1;
        ListNode curl2 = l2;
        boolean startSum = false;
        boolean carry = false;

        while (curl1 != null && curl2 != null) {
            curl1 = curl1.next;
            curl2 = curl2.next;

            if (curl1 == null && !startSum) {
                curInsert.next = l2;
                while (curInsert.next != curl2) {
                    curInsert = curInsert.next;
                }
                curl1 = l1;
                startSum = true;
            } else if (curl2 == null && !startSum) {
                curInsert.next = l1;
                while (curInsert.next != curl1) {
                    curInsert = curInsert.next;
                }
                curl2 = l2;
                startSum = true;
            } else if (curl1 == null && curl2 == null && !startSum){
                curl1 = l1;
                curl2 = l2;
            }
            if (startSum) {
                int sum = curl1.val + curl2.val;
                if (carry){
                    sum++;
                    carry=false;
                }
                if (sum <= 9) {
                    ListNode insert = new ListNode(sum);
                    curInsert.next = insert;
                    curInsert = curInsert.next;
                }else{
                    ListNode insert = new ListNode(sum % 10);
                    curInsert.next = insert;
                    curInsert = curInsert.next;
                    carry = true;
                }
                curl1 = curl1.next;
                curl2 = curl2.next;
            }
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
