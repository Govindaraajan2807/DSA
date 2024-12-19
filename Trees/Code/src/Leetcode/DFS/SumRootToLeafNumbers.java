package Leetcode.DFS;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

public class SumRootToLeafNumbers {
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

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return helper(root, 0);
        }

        private int helper(TreeNode node,int sum) {
            if(node == null){
                return 0;
            }
            sum = sum * 10 + node.val;
            if(node.left == null && node.right == null){
                return sum;
            }
            int left = helper(node.left,sum);
            int right = helper(node.right,sum);

            return left + right;
        }
    }
}
