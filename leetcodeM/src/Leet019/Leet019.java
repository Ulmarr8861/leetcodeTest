package Leet019;

public class Leet019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Leet019 l19 = new Leet019();
        ListNode result = l19.removeNthFromEnd2(head, 2);
        System.out.println("===");
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int length = getLength(dummy);
        for (int i = 1; i < length - n +1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        for (int i = 0; head.next != null; i++) {
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        if (n <= 0 || head == null) {
            return head;
        }
        int l = reverse(head, n);

        if (l == 1 && index.next == null) {
            return new ListNode();
        } else if (l == 1 && index.next != null) {
            return head.next;
        }
        for (int i = 1; i < l-1; i++) {
            if (index.next == null) {
                return head;
            }
            index = index.next;
        }
        index.next = index.next.next;
        return head;
    }

    public int reverse(ListNode head, int n) {
        int count = 0;
        int l = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return l = count - n + 1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}