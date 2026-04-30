package p83_remove_duplicates_from_sorted_list;

import models.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (head != null) {
            if (curr.val != head.val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
        ListNode l3 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode l4 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
        ListNode l5 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(2)))));
        ListNode l6 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))));
        ListNode l7 = new ListNode(1);

        System.out.println(s.deleteDuplicates(l1));
        System.out.println(s.deleteDuplicates(l2));
        System.out.println(s.deleteDuplicates(l3));
        System.out.println(s.deleteDuplicates(l4));
        System.out.println(s.deleteDuplicates(l5));
        System.out.println(s.deleteDuplicates(l6));
        System.out.println(s.deleteDuplicates(l7));
    }
}
