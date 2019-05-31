package leetcode;

/***
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class N148sortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);

        mid.next = null;

        ListNode left = sortList(head);

        return merge(left, right);
    }

    public ListNode findMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        if (left.val <= right.val){
            left.next = merge(left.next, right);
            return left;
        }else {
            right.next = merge(right.next, left);
            return right;
        }
    }
}
