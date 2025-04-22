public class ListNode {
    int value;
    ListNode next;

    public ListNode(int val) {
        this.value = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
    