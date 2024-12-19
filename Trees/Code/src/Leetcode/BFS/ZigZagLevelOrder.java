package Leetcode.BFS;
/*
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */

import java.util.*;

public class ZigZagLevelOrder {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        boolean leftToRight = true;
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(leftToRight){
                    TreeNode currentNode = deque.pollFirst();
                    list.add(currentNode.val);
                    if(currentNode.left != null){
                        deque.addLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        deque.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.pollLast();
                    list.add(currentNode.val);
                    if(currentNode.right != null){
                        deque.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        deque.addFirst(currentNode.left);
                    }
                }
            }
            result.add(list);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
