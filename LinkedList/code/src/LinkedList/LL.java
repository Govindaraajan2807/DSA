package LinkedList;

public class LL {
    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size=0;
    }

    private Node getMiddleNode(Node head) {
        Node slow =  head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //iterative recursion
    public Node reverseIterative(Node node){
        if(head == null){
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
//        head = prev;
        return prev;
    }

    //recursion reverse
    public void reverse(Node node){
       if(node == tail){
           head = tail;
           return;
       }
       reverse(node.next);
       tail.next = node;
       tail = node;
       tail.next = null;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // inserting element at first. Added element will be the head
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value +" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
