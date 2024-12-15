package com.company.BinaryTree;

import Leetcode.RangeSum;

import java.util.ArrayList;

public class BoundaryTraversal {
    private TreeNode root;

    public static void main(String[] args) {
        BoundaryTraversal bts = new BoundaryTraversal();
        bts.createBinaryTree();
        /*ArrayList < Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(bts.root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }*/
        System.out.println(sumOfLeftLeaves(bts.root));

    }

/*--------------------------------------------------------------------------------------------------------------------------------
    //https://leetcode.com/problems/sum-of-left-leaves/
---------------------------------------------------------------------------------------------------------------------------------- */

    public static int sumOfLeftLeaves(TreeNode root) {
       return helper(root, false,0);
    }


    public static int helper(TreeNode root, boolean flag, int sum){
        if(root == null){
            return 0;
        }
        if(flag && isLeafNode(root)){
            sum += root.data;
        }

        helper(root.left,true,sum);
        helper(root.right,false,sum);
        return sum;
    }
    public static boolean isLeafNode(TreeNode root){
        return root.left == null && root.right == null;
    }

/*--------------------------------------------------------------------------------------------------------------------------------
    // Boundary Traversal
---------------------------------------------------------------------------------------------------------------------------------- */
    static ArrayList < Integer > printBoundary(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (!isLeaf(node))
            ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }
    static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    static void addLeftBoundary(TreeNode root, ArrayList<Integer> res){
        TreeNode current = root.left;
        while(current != null){
            if(!isLeaf(current))
                res.add(current.data);
            if(current.left != null) current = current.left;
            else
                current = current.right;
        }
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> res){
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode current = root.right;
        while(current != null){
            if(!isLeaf(current))
                temp.add(current.data);
            if(current.right != null) current = current.right;
            else
                current = current.left;
        }

        for(int i=temp.size()-1; i>=0; --i){
            res.add(temp.get(i));
        }
    }

    static void addLeaves(TreeNode root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }



/*--------------------------------------------------------------------------------------------------------------------------------
      // CREATE BINARY TREE
---------------------------------------------------------------------------------------------------------------------------------- */
    public void createBinaryTree(){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode fifteen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20);


        /*root = one;
        one.left = two;
        two.left = three;
        three.right = four;
        four.left=five;
        four.right = six;
        one.right=seven;
        seven.right=eight;
        eight.left=nine;
        nine.left=eleven;
        nine.right=ten;*/
        root = three;
        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
    }

    public class TreeNode{
        private TreeNode root;
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }

    }
}

