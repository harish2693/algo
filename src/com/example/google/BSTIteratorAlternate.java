/**
 * Complexity analysis
 *
 * Time complexity : O(N) is the time taken by the constructor for the iterator.
 * The problem statement only asks us to analyze the complexity of the two functions, however, when implementing a class,
 * it's important to also note the time it takes to initialize a new object of the class and in this case it would be linear in terms of the number of nodes in the BST. In addition to the space occupied by the new array we initialized, the recursion stack for the inorder traversal also occupies space but that is limited to O(h)O(h) where hh is the height of the tree.
 * next() would take O(1)
 * hasNext() would take O(1)
 * Space complexity : O(N) since we create a new array to contain all the nodes of the BST. This doesn't comply with the requirement specified in the problem statement that the maximum space complexity of either of the functions should be O(h)O(h) where hh is the height of the tree and for a well balanced BST, the height is usually logNlogN. So, we get great time complexities but we had to compromise on the space. Note that the new array is used for both the function calls and hence the space complexity for both the calls is O(N)O(N).
 */

package com.example.google;

import com.example.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIteratorAlternate {

    private List<Integer> nodesSorted;
    private int index;

    public BSTIteratorAlternate(TreeNode root) {

        // Array containing all the nodes in the sorted order
        this.nodesSorted = new ArrayList<>();

        // Pointer to the next smallest element in the BST
        this.index = -1;

        // Call to flatten the input binary search tree
        this.addInorder(root);
    }

    private void addInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        this.addInorder(root.left);
        this.nodesSorted.add(root.val);
        this.addInorder(root.right);
    }

    public boolean hasNext() {
        if (index+1 > nodesSorted.size()-1) {
            return false;
        }
        return nodesSorted.get(index+1) != null;
    }

    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);


        BSTIteratorAlternate i = new BSTIteratorAlternate(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
