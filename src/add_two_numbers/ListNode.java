package add_two_numbers;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next != null) {
            return this.val + " " + this.next;
        }
        return String.valueOf(this.val);
    }
}
