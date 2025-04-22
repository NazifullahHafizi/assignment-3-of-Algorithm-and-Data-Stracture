public class LinkedListUtils {

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode nextHalf = mid.next;
        mid.next = null;

        ListNode left = sort(head);
        ListNode right = sort(nextHalf);

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public ListNode subtract(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null) {
            if (!contains(l2, l1.value)) {
                current.next = new ListNode(l1.value);
                current = current.next;
            }
            l1 = l1.next;
        }

        return dummy.next;
    }

    private boolean contains(ListNode head, int value) {
        while (head != null) {
            if (head.value == value) return true;
            head = head.next;
        }
        return false;
    }
}
