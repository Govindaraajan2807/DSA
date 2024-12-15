package LeetcodeProblems;


public class LeetCode {
    public static void main(String[] args) {
        LeetCode nodeA = new LeetCode();
        nodeA.insertLast(4);
        nodeA.insertLast(1);
        nodeA.insertLast(8);
        nodeA.insertLast(4);
        nodeA.insertLast(5);

        LeetCode nodeB = new LeetCode();
        nodeB.insertLast(5);
        nodeB.insertLast(6);
        nodeB.insertLast(1);
        nodeB.insertLast(8);
        nodeB.insertLast(4);
        nodeB.insertLast(5);

        nodeA.display();
        System.out.println();
        nodeB.display();

        helper(nodeA.head, nodeB.head);
    }
    private ListNode head;
    private ListNode tail;

    private int size;

    public LeetCode() {
        this.size=0;
    }

    public static void helper(ListNode a, ListNode b){
        System.out.println(getIntersectionNode(a,b));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = tempA == null?headB:tempA.next;
            tempB = tempB == null?headA:tempB.next;
        }
        return tempB;
    }

    //https://leetcode.com/problems/remove-linked-list-elements/
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            if(curr.val == val){
                if(prev != null){
                    prev.next = curr.next;
                    curr = prev.next;
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
    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val +" -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    //https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverseIterative(mid);
        ListNode hf = head;

        while(hf != null && hs != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }

    //https://leetcode.com/problems/palindrome-linked-list/submissions/
    public boolean isPalindrome(ListNode head){
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseIterative(mid);
        ListNode reverseHead = secondHead;

        while(head != null && secondHead != null){
            if(head.val != secondHead.val)
                break;
            head = head.next;
            secondHead = secondHead.next;
        }

        reverseIterative(reverseHead);
        if(head == null || secondHead == null)
            return true;
        return false;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseIterative(ListNode node){
        if(node == null){
            return node;
        }
        ListNode prev = null;
        ListNode present = node;
        ListNode next = present.next;

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

    // delete duplicates
    public void duplicates(){
        ListNode node = head;
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
                size--;
            } else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;

        for (int i=0; current != null && i<left-1;i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;

        for(int i=0 ; current != null && i < right - left + 1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        if(last != null){
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    public boolean isPalindromeTest(ListNode head){

        //find middle
        ListNode mid =  getMiddle(head);

        //reverse mid to last
        ListNode secondHead =  reverseII(mid);
        ListNode reverseHead = secondHead;
        ListNode firstHead = head;
        while(head != null && secondHead != null){
            if(head.val != secondHead.val)
                break;
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseII(reverseHead);
        if(head == null || secondHead == null )
            return true;
        return false;

    }

    private ListNode reverseII(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        while(current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <= 1 || head == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        int length = getLength(head);
        int count = length/k;

        while(count > 0){
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;

            for(int i=0 ; i < k ; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            if(last != null){
                prev.next = last;
            } else {
                head = prev;
            }
            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    private int getLength(ListNode head){
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {
      }

//      ListNode(int val) {
//          this.val = val;
//      }

      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
