class BST {
    public class Node {
        Node left;
        Node right;
        int value;
        int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
    private Node root;

    public BST(){

    }

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public Boolean isEmpty(){
        return root == null;
    }

    public Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        if(value > node.value){
            node.right = insert(node.right, value);
        }
        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }
}
