package Easy;

public class SumOfAllNodes {
    private TreeNode root;
    public static void main(String[] args) {
        SumOfAllNodes sum = new SumOfAllNodes();
        sum.createBinaryTree();
        int ans = sum.sumOfAllNode(sum.root);
        System.out.println(ans);


    }
    static int sum =0 ;
    public int sumOfAllNode(TreeNode root){
        if(root == null) {
            return -1;
        }
        int val = root.data;
        sumOfAllNode(root.left);
        sumOfAllNode(root.right);
        return sum += val;
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right =  sixth;
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
/*
 //Method 1

        /*if(root == null){
            return false;
        } else if(root.left == null && root.right == null && targetSum - root.val == 0 ){
            return true;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
        //Method 2 using helper
    traversal(root, targetSum);
        return res;
                }
                boolean res = false;
public void traversal(TreeNode root, int targetSum){
        if(root != null){
        root.val = targetSum - root.val;
        if(root.left == null && root.right == null && root.val == 0){
        res = true;
        return;
        }
        traversal(root.left,root.val);
        traversal(root.right,root.val);
        }
        }
 */



