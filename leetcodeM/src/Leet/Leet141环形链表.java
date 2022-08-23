package Leet;

import Leet.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leet141环形链表 {
    public boolean hasCycle(ListNode head) {
        //注意存的是ListNode
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }



    //快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
