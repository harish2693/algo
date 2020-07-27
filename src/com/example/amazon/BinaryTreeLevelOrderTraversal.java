// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

package com.example.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = getRoot();

        System.out.println(alternative(root));

        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> currentResult = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.remove();

                    currentResult.add(temp.val);

                    if (temp.left != null) {
                        queue.add(temp.left);
                    }

                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }

                result.add(currentResult);
            }
        }

        System.out.println(result);


    }

    public static List<List<Integer>> alternative(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> currentResult = new ArrayList<>();
            TreeNode tempNode = queue.poll();
            currentResult.add(tempNode.val);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);

            result.add(currentResult);
        }
        return result;
    }

    public static TreeNode getRoot() {
        TreeNode root = new TreeNode(3);
        TreeNode al = new TreeNode(9);
        TreeNode ar = new TreeNode(20);
        TreeNode arl = new TreeNode(15);
        TreeNode arr = new TreeNode(7);

        root.left = al;
        root.right = ar;
        root.right.left = arl;
        root.right.right = arr;

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}