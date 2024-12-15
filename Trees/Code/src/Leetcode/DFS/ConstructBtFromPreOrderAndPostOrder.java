package Leetcode.DFS;

import java.util.Arrays;

public class ConstructBtFromPreOrderAndPostOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

            return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {

            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            if(preStart == preEnd){
                return root;
            }
            int leftRootValue = preorder[preStart+1];
            int leftRootIndex = postStart;

            while(postorder[leftRootIndex] != leftRootValue){
                leftRootIndex++;
            }

            int leftSubTreeSize = leftRootIndex - postStart + 1;

            root.left = construct(preorder,preStart+1,preStart+leftSubTreeSize,postorder,postStart,leftRootIndex);
            root.right = construct(preorder,preStart+1+leftSubTreeSize,preEnd,postorder,1+leftRootIndex,postEnd-1);

            return root;

        }
    }
}
