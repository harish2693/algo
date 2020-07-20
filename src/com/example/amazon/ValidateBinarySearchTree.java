// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package com.example.amazon;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(validBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(validBSTIterative(root));
    }

    public static boolean validBSTRecursive(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        } else if (root.val >= maxValue || root.val <= minValue) {
            return false;
        } else {
            return validBSTRecursive(root.left, minValue, root.val) && validBSTRecursive(root.right, root.val, maxValue);
        }
    }

    public static boolean validBSTIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long leftChildVal = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= leftChildVal) {
                return false;
            }

            leftChildVal = root.val;
            root = root.right;
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
