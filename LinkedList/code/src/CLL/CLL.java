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
        boolean flag = false;
        Node start = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                start = slow;
                flag = true;
            }
            if(flag)
                break;
        }
        slow = start;
        int len = 1;
        slow = slow.next;
        while(slow != start){
            slow = slow.next;
            len++;
        }
        return len;
    }

    public Node findFirstCycleNode(){
        Node f = head;
        Node s = head;
        int cycleLength = cycleLength(f,s);

        s = head;
        while(cycleLength > 0){
            s = s.next;
            cycleLength--;
        }
        f = head;
        while(s != f){
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public int cycleLength(Node f, Node s){
        int cycleLength = 0;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                Node temp = s;
                do {
                    temp = temp.next;
                    cycleLength++;
                }while(temp != s);
                return cycleLength;
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
