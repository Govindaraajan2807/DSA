package com.company.BinaryTree;

import Easy.SumOfAllNodes;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBT {
    private TreeNode root;

    public static void main(String[] args) {
        LevelOrderBT levelOrderBT = new LevelOrderBT();
        levelOrderBT.createBinaryTree();
        levelOrderBT.levelOrder(levelOrderBT.root);
        System.out.print("null");
    }
    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " -> ");
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
    }
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);


        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right =  sixth;
    }

    class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

}
