package Leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/description/

public class PathSum_II {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> pathResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, pathResult, result);
        return result;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result){
        if(node == null){
            return;
        }

        currentPath.add(node.val);

        if(node.left == null && node.right == null && targetSum == node.val){
            result.add(new ArrayList<>(currentPath));
        }else {
            helper(node.left, targetSum - node.val,currentPath, result);
            helper(node.right, targetSum - node.val,currentPath, result);
        }

        currentPath.removeLast();


    }
}
