package com.lab.studyplan.algorithm1.twopointers;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}


public class MiddleOfTheLinkedList876 {

    //Input: head = [1,2,3,4,5]
    //Output: [3,4,5]

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

         return slow;
    }

}
