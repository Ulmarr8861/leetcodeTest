package 分治;

import java.util.List;

public class l023合并K个升序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l023合并K个升序链表 l23 = new l023合并K个升序链表();
        ListNode ans = l23.mergeTwoLists2(l1, l2);
        System.out.println("333");

    }

    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head.next;
    }

    public ListNode mergeLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge2(lists, 0, lists.length - 1);


    }

    private ListNode merge2(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (r + l) / 2;
        return mergeTwoLists2(merge2(lists, l, mid), merge2(lists, mid + 1, r));
    }

    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int a1 = 0, a2 = 0;
        while (l1 != null || l2 != null) {
            a1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            a2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (a1 <= a2 && a1 != Integer.MAX_VALUE) {
                tail.next = new ListNode(a1);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(a2);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return head.next;
    }
}