package com.company.BinaryTree;

import java.util.Stack;

public class PostOrderBt {
    private TreeNode root;
    public static void main(String[] args) {
        PostOrderBt postOrderBt = new PostOrderBt();
        postOrderBt.createBinaryTree();
        postOrderBt.postOrderIter(postOrderBt.root);
    }

    public void postOrderIter(TreeNode root){
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " -> ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " -> ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }


    public void postOrderRec(TreeNode root){
        if(root == null){
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data +" -> ");
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
