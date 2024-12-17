package Leetcode.DFS;

public class ConstructBSTfromPreorder {
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

        int index = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode construct(int[] preorder, int start, int end) {
            if (index == preorder.length || preorder[index] > end) {
                return null;
            }

            int val = preorder[index++];
            TreeNode root = new TreeNode(val);

            root.left = construct(preorder, start, val);
            root.right = construct(preorder, val, end);

            return root;

        }
    }
}
