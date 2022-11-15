package com.company.BinaryTree;

public class InsertValueInBST {
    private TreeNode root;

    public static void main(String[] args) {
        InsertValueInBST bst = new InsertValueInBST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);

        bst.inOrder();
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+"->");
        inOrder(root.right);
    }

    private void insert(int value){
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left,value);
        } else if(value > root.data){
            root.right = insert(root.right,value);
        }
        return root;
    }
    class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }
}
