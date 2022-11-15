package LeetcodeProblems;


import LinkedList.LL;

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
