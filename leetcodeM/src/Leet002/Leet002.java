package Leet002;

import Leet141.ListNode;

public class Leet002{
    public static void main(String[] args) {
        System.out.println("");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        int n1 = 0, n2 = 0;
        int helper = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;

            pre.next = new ListNode((n1 + n2) % 10 + helper);
            helper = (n1 + n2) / 10;
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        return result.next;
    }
}