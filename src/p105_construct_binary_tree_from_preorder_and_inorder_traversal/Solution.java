package p105_construct_binary_tree_from_preorder_and_inorder_traversal;

import models.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        return construct(preorder, inorder, 0, inorder.length);
    }

    private static TreeNode construct(int[] preorder, int[] inorder, int left, int right) {
        if (left == right - 1) return new TreeNode(inorder[left]);

        for (int pre : preorder) {
            for (int i = left; i < right; i++) {
                if (pre == inorder[i]) {
                    TreeNode leftNode = construct(preorder, inorder, left, i);
                    TreeNode rightNode = construct(preorder, inorder, i + 1, right);
                    return new TreeNode(inorder[i], leftNode, rightNode);
                }
            }
        }

        return null;
    }

    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTreeBest(int[] preorder, int[] inorder) {
        this.preorderIndex = 0;
        this.inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderIndexMap.get(rootValue);

        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})); //Output: [3 9 null null 20 15 null null 7 null null]
        System.out.println(s.buildTree(new int[]{-1}, new int[]{-1})); //Output: [-1 null null]
        System.out.println(s.buildTree(new int[]{3, 9, 2, 1, 20, 15, 7}, new int[]{2, 9, 1, 3, 15, 20, 7})); //Output: [3 9 2 null null 1 null null  20 15 null null 7 null null]

        System.out.println(s.buildTreeBest(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})); //Output: [3 9 null null 20 15 null null 7 null null]
        System.out.println(s.buildTreeBest(new int[]{-1}, new int[]{-1})); //Output: [-1 null null]
        System.out.println(s.buildTreeBest(new int[]{3, 9, 2, 1, 20, 15, 7}, new int[]{2, 9, 1, 3, 15, 20, 7})); //Output: [3 9 2 null null 1 null null  20 15 null null 7 null null]
    }
}
