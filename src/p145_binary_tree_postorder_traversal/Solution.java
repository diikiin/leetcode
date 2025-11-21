package p145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(root, traversal);
        return traversal;
    }

    private static void traverse(TreeNode root, List<Integer> traversal) {
        if (root != null) {
            traverse(root.left, traversal);
            traverse(root.right, traversal);
            traversal.add(root.val);
        }
    }

    public List<Integer> postorderTraversalBest(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) return traversal;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.peek();

                if (root.right == null || root.right == prev) {
                    traversal.add(root.val);
                    stack.pop();
                    prev = root;
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }

        return traversal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode r1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(s.postorderTraversal(r1));

        TreeNode r2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));
        System.out.println(s.postorderTraversal(r2));

        TreeNode r3 = new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        System.out.println(s.postorderTraversal(r3));

        System.out.println(s.postorderTraversalBest(r1));
        System.out.println(s.postorderTraversalBest(r2));
        System.out.println(s.postorderTraversalBest(r3));
    }
}
