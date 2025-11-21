package p94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) return traversal;

        return traverse(root, traversal);
    }

    private static List<Integer> traverse(TreeNode root, List<Integer> traversal) {
        if (root.left != null) traverse(root.left, traversal);
        traversal.add(root.val);
        if (root.right != null) traverse(root.right, traversal);

        return traversal;
    }

    public List<Integer> inorderTraversalBest(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) return traversal;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            traversal.add(curr.val);
            curr = curr.right;
        }

        return traversal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode r1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(s.inorderTraversal(r1));

        TreeNode r2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));
        System.out.println(s.inorderTraversal(r2));

        System.out.println(s.inorderTraversalBest(r1));
        System.out.println(s.inorderTraversalBest(r2));

        TreeNode r3 = new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        System.out.println(s.inorderTraversalBest(r3));
    }
}
