package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/*
        curr = head; //1 -> 2 //9 -> 11
        currNext = curr. next; //2 -> 3 //12

        int count = 0;
        int val = -1;
        while(count <10 ){
        curr = currNext; //2 9
        currNext = currNext.next; //3 10
        count++; 10
        }
        curr = 9
        currNExt = 10
 */
 */

        int val = currNext.val; //10
        curr.next = currNext.next; 11
        currNext = curr.next.next;

        return val;