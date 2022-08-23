
public class TestAny {
    public static boolean findCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        } else if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;
        while (fast != null && fast.next !=null) {
            if (slow == fast) {
                flag = true;
                break;

            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return flag;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        boolean a = findCycle(head);
        System.out.println(a);
    }
}
