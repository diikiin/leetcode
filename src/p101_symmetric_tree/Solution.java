package p101_symmetric_tree;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode p1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(s.isSymmetric(p1));

        TreeNode p2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(s.isSymmetric(p2));

        TreeNode p3 = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(2, new TreeNode(2), null));
        System.out.println(s.isSymmetric(p3));

        TreeNode p4 = new TreeNode(5, new TreeNode(2, new TreeNode(4, null, new TreeNode(1, new TreeNode(2), null)), null), new TreeNode(2, null, new TreeNode(1, null, new TreeNode(4, new TreeNode(2), null))));
        System.out.println(s.isSymmetric(p4));
    }
}
