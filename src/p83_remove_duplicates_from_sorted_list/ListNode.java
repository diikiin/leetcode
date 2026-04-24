package p83_remove_duplicates_from_sorted_list;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
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
