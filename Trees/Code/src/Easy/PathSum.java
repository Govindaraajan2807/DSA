package Easy;

/*
       leetcode : https://leetcode.com/problems/path-sum/
 */

public class PathSum {

    private TreeNode root;

    public static void main(String[] args) {
        PathSum bt = new PathSum();
        bt.createBinaryTree();
        System.out.println(hasPathSum(bt.root,22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        //Method 1

        /*if(root == null){
            return false;
        } else if(root.left == null && root.right == null && targetSum - root.val == 0 ){
            return true;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }*/

        //Method 2 using helper
        traversal(root, targetSum,0);
        return res;
    }
    static boolean res = false;
    public static void traversal(TreeNode root, int targetSum, int sum){
        if(root != null){
            sum += root.data;
            if(root.left == null && root.right == null && sum == targetSum){
                res = true;
                return;
            }
            traversal(root.left,targetSum,sum);
            traversal(root.right,targetSum,sum);
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(5);
        TreeNode second = new TreeNode(4);
        TreeNode third = new TreeNode(8);
        TreeNode fourth = new TreeNode(11);
        TreeNode fifth = new TreeNode(7);
        TreeNode sixth = new TreeNode(2);
        TreeNode seventh = new TreeNode(13);
        TreeNode eight = new TreeNode(4);
        TreeNode ninth = new TreeNode(1);
//        TreeNode tenth = new TreeNode(1);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        fourth.right = sixth;
        fourth.left = fifth;
        third.left = seventh;
        third.right = eight;
        eight.right = ninth;
    }

    class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

}
