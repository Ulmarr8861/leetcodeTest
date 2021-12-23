package Leet021;

import java.util.List;

public class Leet021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        Leet021 l21 = new Leet021();
        ListNode l3 = l21.mergeTwoLists(l1, l2);
        System.out.println("===========");
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode cur = new ListNode(-1);
        ListNode ans = cur;
        while (l1 != null || l2 != null) {
            int a1 = l1 != null ? l1.val : 999;
            int a2 = l2 != null ? l2.val : 999;
            if (a1 <= a2) {
                cur.next = new ListNode(a1);
                cur = cur.next;
                l1 = l1.next;

            } else {
                cur.next = new ListNode(a2);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return ans.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
