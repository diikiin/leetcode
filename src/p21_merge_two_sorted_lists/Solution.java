package p21_merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            ListNode temp = new ListNode(list1.val, list1.next);
            list1.val = list2.val;
            list1.next = mergeTwoLists(temp, list2.next);
        }

        return list1;
    }

    public ListNode mergeTwoListsBest(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(solution.mergeTwoLists(list1, list2));

        ListNode list3 = null;
        ListNode list4 = null;
        System.out.println(solution.mergeTwoLists(list3, list4));

        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        System.out.println(solution.mergeTwoLists(list5, list6));

        System.out.println(solution.mergeTwoListsBest(list1, list2));
        System.out.println(solution.mergeTwoListsBest(list3, list4));
        System.out.println(solution.mergeTwoListsBest(list5, list6));
    }
}
