package com.Govind.Stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new DynamicStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.pop());

        System.out.println(stack.toString());

    }
}
