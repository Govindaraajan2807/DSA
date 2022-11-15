package com.company;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        //pushes all the 3 values 1 by 1 in sequential order
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        //pops out last added value -> 3
        stack.pop();
        System.out.println(stack);

        stack.push(3);

        //searches for the value and returns boolean value
        boolean status = stack.isEmpty();
        System.out.println(status);

        //search for that value and returns the index. Returns -1 if value is not present
        int indexFound = stack.search(6);
        System.out.println(indexFound);

        //returns the top element
        System.out.println(stack.peek());

        //iterating over an stack
        Iterator iterator = stack.iterator();
        while(iterator.hasNext()){
            Object value = iterator.next();
            System.out.println(value);
        }

        //returns size of stack
        System.out.println(stack.size());

        //sorts the stack
        stack.sort(null);
        System.out.println(stack);

    }
}
