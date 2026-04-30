package p111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        return nextNode(root, 1);
    }

    private static int nextNode(TreeNode node, int minDepth) {
        if (node.left == null && node.right == null) return minDepth;
        if (node.left != null && node.right == null) return nextNode(node.left, minDepth + 1);
        if (node.left == null) return nextNode(node.right, minDepth + 1);
        return Math.min(nextNode(node.left, minDepth + 1), nextNode(node.right, minDepth + 1));
    }

    public int minDepthFastest(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(s.minDepth(new TreeNode(1, null, new TreeNode(2))));
        System.out.println(s.minDepth(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));

        System.out.println(s.minDepthFastest(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(s.minDepthFastest(new TreeNode(1, null, new TreeNode(2))));
        System.out.println(s.minDepthFastest(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))))));
    }
}
