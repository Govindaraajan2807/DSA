package Leetcode.DFS;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class MaxPathSum {
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
    int globalMax = 0;
    public int maxPathSum(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        int sum = left+right+node.val;
        globalMax = Math.max(sum,globalMax);

        return Math.max(left,right)+node.val;
    }

}
