package Leetcode.DFS;

import java.util.Arrays;

public class ConstructBtFromPreOrderAndInorder {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        int root = preorder[0];
        int index = -1;
        for(int i=0;i< inorder.length;i++){
            if(inorder[i] == root){
                index=i;
            }
        }

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = buildTree(Arrays.copyOfRange(preorder,1,index+1), Arrays.copyOfRange(inorder,0,index));
        rootNode.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length), Arrays.copyOfRange(inorder,index+1,inorder.length));

        return rootNode;
    }
}
