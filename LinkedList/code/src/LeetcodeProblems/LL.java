package LeetcodeProblems;

public class LL {

    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();
        first.insertLast(4);
        first.insertLast(1);
        first.insertLast(8);
        first.insertLast(4);
        first.insertLast(5);

        second.insertLast(5);
        second.insertLast(6);
        second.insertLast(1);
        second.insertLast(8);
        second.insertLast(4);
        second.insertLast(5);

        helper(first,second);

    }

    private Node head;
    private Node tail;

    private int size;

    public LL() {
        this.size = 0;
    }

    public static void helper(LL first, LL second){
        System.out.println(getIntersectionNode(first,second));
    }

    public static Node getIntersectionNode(LL listA, LL listB) {

        Node tempA = listA.head;
        System.out.println(listA.head.value);
        System.out.println(listB.head.value);
        Node tempB = listB.head;
        while(tempA.value != tempB.value){
            tempA = tempA == null? listB.head:tempA.next;
            tempB = tempB == null? listA.head:tempB.next;
        }
        return tempA;
    }

    public static Node removeElements(LL list, int val) {
        Node prev = null;
        Node head = list.head;
        Node curr = head;

        while(curr != null){
            if(curr.value == val){
                if(prev != null){
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    head = curr.next;
                    curr = head;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    //merge problem
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }


    public void deleteDuplicates(){
        Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
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
        System.out.println("END");
    }

    public class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
