package p100_same_tree;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(s.isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(3));
        System.out.println(s.isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(s.isSameTree(p3, q3));
    }
}
