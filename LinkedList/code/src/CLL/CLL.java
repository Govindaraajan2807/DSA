package CLL;

public class CLL {

    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

  /*  public int detectCycle(){

    }*/

    public int cycleLength(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                int len = 0;
                do{
                    temp = temp.next;
                    len++;
                } while(temp != slow);
                return len;
            }
        }
        return 0;
    }

    public void delete(int value){
        Node node = head;
        if(node == null){
            return;
        }
        if(node.val == value){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = node.next;
            if(n.val == value){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while(node != head);
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display(){
        Node node = head;
        if(head != null){
            do {
                System.out.print(node.val +" -> ");
                node = node.next;
            } while(node != head);
        }
        System.out.println("HEAD");
    }



    private class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
