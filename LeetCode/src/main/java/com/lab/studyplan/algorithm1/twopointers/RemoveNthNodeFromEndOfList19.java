package com.lab.studyplan.algorithm1.twopointers;


public class RemoveNthNodeFromEndOfList19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int count = 1;

        while (count <= n) {
            fast = fast.next;
            count++;
        }

        if (fast == null) {
            return slow.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
