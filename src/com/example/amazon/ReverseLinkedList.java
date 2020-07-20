// Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package com.example.amazon;

import java.util.Arrays;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode newHead = null;

        /**
         *
         * newHead = null
         * head = 2 -> 4 -> 3
         *
         * 1st loop
         *
         * next = 4 -> 3
         * head = 2 -> null
         * newHead = 2
         * head = 4 -> 3
         *
         * 2nd loop
         *
         * next = 3
         * head = 4 -> 2
         * newHead = 4 -> 2
         * head = 3
         *
         * 3rd loop
         *
         * next = null
         * head = 3 -> 4 -> 2
         * newHead = 3 -> 4 -> 2
         * head = null
         *
         */
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}
