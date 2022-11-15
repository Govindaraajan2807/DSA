package SLL;

import LeetcodeProblems.LeetCode;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size=0;
    }

    public void swapPairs(LL head) {
        if(head.head == null) return;
        Node node = head.head;
        while(node != null && node.next != null){
            int temp = node.value;
            node.value = node.next.value;
            node.next.value = temp;
            node = node.next.next;
        }
//        return head;
    }

    public static Node removeElements(Node head, int val) {
        Node node = head;
        while(node.next != null){
            if(node.value == val){
                node=node.next.next;
            }
            node = node.next;
        }
        return head;
    }

// insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val,--index,node.next);
        return node;
    }

// find node with given value
    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

//delete at given index
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index ==  size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

// delete last element
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next=null;
        return val;

    }
    // get element at given index
    public Node get(int index){
        Node node = head;
        for(int i=0; i<index;i++){
            node = node.next;
        }
        return node;
    }

// deleting first element
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return val;
    }

// inserting element at given index
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

// inserting element at last
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
