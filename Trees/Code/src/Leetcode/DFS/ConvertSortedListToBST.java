package Leetcode.DFS;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class ConvertSortedListToBST {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
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
    ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        current = head;
        int size = getSize(head);
        return frameTree(0, size - 1);
    }

    private int getSize(ListNode current) {
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    private TreeNode frameTree(int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the mid-point
        int mid = start + (end - start) / 2;

        // Create the root node first (pre-order step)
        TreeNode leftSubtree = frameTree(start, mid - 1);

        TreeNode root = new TreeNode(current.val);
        current = current.next; // Move to the next node in the list

        // Recursively build the left subtree
        root.left = leftSubtree;

        // Recursively build the right subtree
        root.right = frameTree(mid + 1, end);

        return root;
    }

}
