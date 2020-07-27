// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package com.example.airbnb;

import com.example.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] input = {-20, -10, -4, 0, 5, 9};
        sortedArrayToBST(input);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int start, int end) {
        if(start <= end) {
            int mid = (start + end) / 2;

            TreeNode current = new TreeNode(nums[mid]);

            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);

            return current;
        }

        return null;
    }
}
