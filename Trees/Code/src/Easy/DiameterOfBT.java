package Easy;

public class DiameterOfBT {
//    static int diameter = 0;
    public static void main(String[] args) {

    }
    public int diameterOfBinaryTree(TreeNode root) {
         int[] diameter = new int[1];

        height(root, diameter);
        return diameter[0];
    }
    int height(TreeNode root, int[] diameter){
        if(root == null) return 0;

        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);

        return 1 + Math.max(lh,rh);
    }

    private TreeNode root;
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
