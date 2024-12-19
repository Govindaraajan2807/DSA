package Leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 */
public class AverageOfLevels {
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                sum+= currentNode.val;
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            sum = sum/size;
            result.add(sum);
        }
        return result;
    }

    public List<Double> averageOfLevels2(TreeNode root){
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            double average = sum/size;
            result.add(average);
        }
        return result;
    }
}
