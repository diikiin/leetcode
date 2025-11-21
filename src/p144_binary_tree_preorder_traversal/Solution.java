package p144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        traverse(root, traversal);
        return traversal;
    }

    private static void traverse(TreeNode root, List<Integer> traversal) {
        if (root != null) {
            traversal.add(root.val);
            traverse(root.left, traversal);
            traverse(root.right, traversal);
        }
    }

    public List<Integer> preorderTraversalBest(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) return traversal;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            traversal.add(root.val);

            if (root.right != null)
                stack.add(root.right);
            if (root.left != null)
                stack.add(root.left);

            root = stack.pop();
        }

        return traversal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode r1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(s.preorderTraversal(r1));

        TreeNode r2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));
        System.out.println(s.preorderTraversal(r2));

        TreeNode r3 = new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        System.out.println(s.preorderTraversal(r3));

        System.out.println(s.preorderTraversalBest(r1));
        System.out.println(s.preorderTraversalBest(r2));
        System.out.println(s.preorderTraversalBest(r3));
    }
}
