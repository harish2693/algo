// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
// and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 342
 * 465
 *
 * 243
 * 564
 *   807
 */

package com.example.amazon;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode current1 = new ListNode(2);
        current1.next = new ListNode(4);
        current1.next.next = new ListNode(3);

        ListNode current2 = new ListNode(5);
        current2.next = new ListNode(6);
        current2.next.next = new ListNode(4);

        int sum = 0;
        ListNode result = null;
        ListNode prev = null;
        ListNode temp = null;

        while (current1 != null || current2 != null) {
            sum /= 10;

            if (current1 != null) {
                sum += current1.val;
                current1 = current1.next;
            }

            if (current2 != null) {
                sum += current2.val;
                current2 = current2.next;
            }

            temp = new ListNode(sum % 10);

            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;
        }
        if (sum / 10 == 1) {
            prev.next = new ListNode(1);
        }
        System.out.println(result);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + " -> " + next.val + " -> " + next.next.val;
    }
}
