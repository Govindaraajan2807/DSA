package Easy;

public class FindMax {
    private TreeNode root;
    public static void main(String[] args) {
        FindMax bt = new FindMax();
        bt.createBinaryTree();
        int val = bt.findMax(bt.root);
//        int ans = bt.findMax(bt.root,0);
        System.out.println(val);

    }
//    static int max = 0;
    private static int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) {
            result = left;
        }
        if(right > result){
            result = right;
        }
        return result;
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
 if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) {
            result = left;
        }
        if(right > result){
            result = right;
        }
        return result;
 */
