package Leet142;

import Leet101.TreeNode;
import Leet141.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leet142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node3.next = node1;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        ListNode result = new Leet142().detectCycle2(head);
        System.out.println("result");
    }

    //运行速度慢
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode listNode = null;
        while (head != null) {
            if (!nodeSet.add(head)) {
                listNode = head;
                break;
            }
            head = head.next;
        }
        return listNode;
    }


    //快慢指针(先找到slow和fast相遇的时候，再判断pre和slow相遇的时候)
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        return null;
    }
}
