
package Leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

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
             

            class Solution {
                public List<List<Integer>> levelOrder(TreeNode root) {
                    List<List<Integer>> result = new ArrayList<>();
                    if(root == null) {
                        return result;
                    }
                    Queue<TreeNode> queue = new LinkedList<>();
                    queue.add(root);
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        List<Integer> levelList = new ArrayList<>();
                        for(int i=0; i<size; i++){
                            TreeNode temp = queue.poll();
                            levelList.add(temp.val);
                            if(temp.left != null) queue.add(temp.left);
                            if(temp.right != null) queue.add(temp.right);
                        }
                        result.add(levelList);
                    }
                    return result;
                }
              }
}

