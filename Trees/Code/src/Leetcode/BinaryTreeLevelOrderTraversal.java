package Leetcode;
        /*
            https://leetcode.com/problems/binary-tree-level-order-traversal/

        */
public class BinaryTreeLevelOrderTraversal {
            /**
             * Definition for a binary tree node.
             * public class TreeNode {
             *     int val;
             *     TreeNode left;
             *     TreeNode right;
             *     TreeNode() {}
             *     TreeNode(int val) { this.val = val; }
             *     TreeNode(int val, TreeNode left, TreeNode right) {
             *         this.val = val;
             *         this.left = left;
             *         this.right = right;
             *     }
             * }
             */
            class Solution {
                public List<List<Integer>> levelOrder(TreeNode root) {
                    if(root == null) return new ArrayList<>();
                    Queue<TreeNode> queue = new LinkedList<>();
                    queue.add(root);
                    List<List<Integer>> list = new ArrayList<>();
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        List<Integer> levelList = new ArrayList<>();
                        for(int i=0; i<size; i++){
                            TreeNode temp = queue.poll();
                            levelList.add(temp.val);
                            if(temp.left != null) queue.add(temp.left);
                            if(temp.right != null) queue.add(temp.right);
                        }
                        list.add(levelList);
                    }
                    return list;
                }
            }

}
