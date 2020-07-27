// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Complexity analysis
 *
 * Time complexity : The time complexity for this approach is very interesting to analyze. Let's look at the complexities for both the functions in the class:
 *
 * hasNext is the easier of the lot since all we do in this is to return true if there are any elements left in the stack. Otherwise, we return false. So clearly, this is an O(1)O(1) operation every time. Let's look at the more complicated function now to see if we satisfy all the requirements in the problem statement
 *
 * next involves two major operations. One is where we pop an element from the stack which becomes the next smallest element to return. This is a O(1)O(1) operation. However, we then make a call to our helper function _inorder_left which iterates over a bunch of nodes. This is clearly a linear time operation i.e. O(N)O(N) in the worst case. This is true.
 *
 * However, the important thing to note here is that we only make such a call for nodes which have a right child. Otherwise, we simply return. Also, even if we end up calling the helper function, it won't always process N nodes. They will be much lesser. Only if we have a skewed tree would there be N nodes for the root. But that is the only node for which we would call the helper function.
 *
 * Thus, the amortized (average) time complexity for this function would still be O(1)O(1) which is what the question asks for. We don't need to have a solution which gives constant time operations for every call. We need that complexity on average and that is what we get.
 *
 * Space complexity: The space complexity is O(h)O(h) which is occupied by our custom stack for simulating the inorder traversal. Again, we satisfy the space requirements as well as specified in the problem statement.
 */

package com.example.google;

import com.example.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // Stack for the recursion simulation
        stack = new Stack<>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        addLeftInOrder(root);
    }

    private void addLeftInOrder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode nextSmallest = stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (nextSmallest.right != null) {
            this.addLeftInOrder(nextSmallest.right);
        }

        return nextSmallest.val;
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


        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
