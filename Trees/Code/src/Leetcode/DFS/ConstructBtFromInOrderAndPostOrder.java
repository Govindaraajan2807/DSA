package Leetcode.DFS;

import java.util.Arrays;

public class ConstructBtFromInOrderAndPostOrder {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length == 0){
                return null;
            }

            int r = postorder[postorder.length-1];
            int index = 0;

            for(int i=0;i< inorder.length;i++){
                if(inorder[i] == r){
                    index = i;
                }
            }

            TreeNode root = new TreeNode(r);
            root.left = buildTree(Arrays.copyOfRange(inorder,0,index), Arrays.copyOfRange(postorder,0,index));
            root.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length), Arrays.copyOfRange(postorder,index+1,postorder.length-1));

            return root;
        }
}
