// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package com.example.google;

import com.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        System.out.println(treePath(root));
    }

    public static List<String> treePath(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        helper("", root, result);

        return result;
    }

    private static void helper(String current, TreeNode root, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(current + root.val);
        }

        if (root.left != null) {
            helper(current + root.val + "->", root.left, result);
        }

        if (root.right != null) {
            helper(current + root.val + "->", root.right, result);
        }
    }
}
