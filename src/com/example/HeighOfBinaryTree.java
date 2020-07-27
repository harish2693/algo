package com.example;

public class HeighOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(4);

        System.out.println(findHeight(root));

    }

    /**
     * space complexity = height of binary tree (O(n))
     * time complexity = O(n)
     * @param node
     * @return
     */
    public static int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
