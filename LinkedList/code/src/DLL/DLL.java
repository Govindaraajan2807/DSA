package DLL;

public class DLL {

    private Node head;

    public void insert(int after, int val){
        Node p = find(after);
        if(p == null){
            System.out.println("does not exists");
            return;
        }
        // refer the node diagram from kunal's git hub to understand the link
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.previous = p;
        if(node.next != null){
            node.next.previous = node;
        }
    }

    public Node find(int value){
        Node node = head;
        while(node.next != null){
            if(node.val == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertLast(int val){
     Node node = new Node(19);
     Node last = head;

     node.next = null;

     if(head == null){
         node.previous = null;
         head = node;
         return;
     }
     while(last.next != null){
         last = last.next;
     }
     last.next = node;
     node.previous = last;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.previous = null;
        if(head != null) {
            head.previous = node;
        }
        head = node;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }



    private class Node{
        int val;
        Node previous;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node previous, Node next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }

    }
}
