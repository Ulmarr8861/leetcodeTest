package Leet148;

import Leet141.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode rusult = new Leet148().sortList(head);
        System.out.println("=======");
    }
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] nums = list.toArray();
        int[] a = new int[]{4, 2, 1, 3};
        quickSort(a, 0, list.size() - 1);
        return null;
    }

    private void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int pivot = (left + right) >>1;
        int temp = 0;
        while (l < r) {
            while ((int)nums[l] < (int)nums[pivot]) {
                l += 1;
            }
            while ((int)nums[pivot] < (int)nums[r]) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = (int)nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            if (nums[l]==nums[pivot]) {
                l += 1;
            }
            if (nums[r] == nums[pivot]) {
                r -= 1;
            }
            if (l == r) {
                l += 1;
                r -= 1;
            }
            if (left < r) {
                quickSort(nums, left, r);
            }
            if (right > l) {
                quickSort(nums, l, right);
            }



        }
    }
}
