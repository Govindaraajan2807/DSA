package Leetcode;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {
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

        public String serialize(TreeNode root) {
            if (root == null) {
                return "null,";
            }
            return root.val + "," + serialize(root.left) + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            // Use a queue to keep track of nodes to process
            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
            return buildTree(queue);
        }

        public TreeNode buildTree(Queue<String> queue) {
            String val = queue.poll();
            if (val.equals("null")) {
                return null; // Null node, stop recursion
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue); // Reconstruct left subtree
            node.right = buildTree(queue); // Reconstruct right subtree
            return node;

        }
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));