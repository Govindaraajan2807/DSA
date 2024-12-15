package Leetcode.DFS;

import Leetcode.BFS.Symmetric;

public class DiameterOfBT {
    int diameter = 0;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    private int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int dia = left + right +1;
        diameter = Math.max(dia,diameter);

        return Math.min(left,right)+1;
    }
}
