package p2_add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 != null) {
            result.val += l1.val;
        }
        if (l2 != null) {
            result.val += l2.val;
        }

        if (result.val > 9) {
            result.val = result.val - 10;

            if (l1 != null) {
                if (l1.next != null)
                    l1.next.val += 1;
                else
                    l1.next = new ListNode(1);
            } else {
                if (l2.next != null)
                    l2.next.val += 1;
                else
                    l2.next = new ListNode(1);
            }
        }

        result.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null);

        return result;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        Solution s = new Solution();

        System.out.println(s.addTwoNumbers(l1, l2));
    }
}
