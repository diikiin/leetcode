package models;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {this.val = val;}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.val).append(" ");
        if (this.left != null) {
            str.append(this.left).append(" ");
        } else {
            str.append("null ");
        }
        if (this.right!=null){
            str.append(this.right).append(" ");
        } else {
            str.append("null");
        }
        return str.toString();
    }
}
