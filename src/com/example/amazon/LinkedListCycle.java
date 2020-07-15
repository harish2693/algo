//Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

package com.example.amazon;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head;

        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return false;
        }

        ListNode slow = listNode;
        ListNode fast = listNode.next;

        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}