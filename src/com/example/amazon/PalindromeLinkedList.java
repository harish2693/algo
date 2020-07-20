/**
 * Given a singly linked list, determine if is a palindrome
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Follow up: can you do it in O(n) time complexity and O(1) space complexity
 */

package com.example.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(root));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
