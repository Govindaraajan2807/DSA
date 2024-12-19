package Leetcode.DFS;

import Leetcode.BFS.Symmetric;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst

public class KthSmallestElement {
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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return findNode(root,k).val;
    }

    public TreeNode findNode(TreeNode node, int k){
        if(node == null) {
            return null;
        }

        TreeNode left = findNode(node.left,k);
        if(left != null){
            return left;
        }
        count++;

        if(count == k){
            return node;
        }

        return findNode(node.right,k);
    }
}
