package com.company;

import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrderRec(bt.root);
        System.out.println();
        bt.preOrderIter(bt.root);
    }

    //iterative pre-order traversal using stack
    public void preOrderIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data +" -> ");
            //since stack follows LIFO, push right index first
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    // recursive pre-order traversal
    public void preOrderRec(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" -> ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    // method for creating binary tree
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
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
