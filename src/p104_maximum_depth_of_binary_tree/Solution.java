package p104_maximum_depth_of_binary_tree;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return nextNode(root, 1);
    }

    private static int nextNode(TreeNode node, int maxDepth) {
        if (node.left == null && node.right == null) return maxDepth;
        if (node.left != null && node.right == null) return nextNode(node.left, maxDepth + 1);
        if (node.left == null) return nextNode(node.right, maxDepth + 1);
        return Math.max(nextNode(node.left, maxDepth + 1), nextNode(node.right, maxDepth + 1));
    }

    public int maxDepthBest(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepthBest(root.left);
        int right = maxDepthBest(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(s.maxDepth(new TreeNode(1, null, new TreeNode(2))));

        System.out.println(s.maxDepthBest(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(s.maxDepthBest(new TreeNode(1, null, new TreeNode(2))));
    }
}
