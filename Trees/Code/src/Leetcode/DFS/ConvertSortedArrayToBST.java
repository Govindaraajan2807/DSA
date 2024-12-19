package Leetcode.DFS;

import Leetcode.BFS.Symmetric;
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

public class ConvertSortedArrayToBST {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return frameTree(nums,0,nums.length-1);
    }

    public TreeNode frameTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + end /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = frameTree(nums,start,mid-1);
        root.right = frameTree(nums,mid+1,end);

        return root;
    }
}
