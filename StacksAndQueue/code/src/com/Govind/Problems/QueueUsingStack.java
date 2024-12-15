package com.Govind.Problems;
/*
    https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> second = new Stack<>();

    public void add(int item){
        first.push(item);
    }
    public int remove(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int popped = second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return popped;
    }
    public int peek(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }
}
