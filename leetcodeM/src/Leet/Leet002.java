package Leet;

import java.util.List;

public class Leet002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode reuslt = new Leet002().addTwoNumbers(l1, l2);
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        int n1 = 0, n2 = 0;
        int helper = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;

            pre.next = new ListNode(((n1 + n2) % 10 + helper)%10);
            helper = (n1 + n2 + helper) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            pre = pre.next;
            if (helper != 0) {
                pre.next = new ListNode(helper);
            }
        }
        return result.next;
    }

}