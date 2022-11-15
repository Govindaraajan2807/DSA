package com.Govind.Queue;

public class QueueMain {
    public static void main(String[] args) throws QueueException {
        CustomQueue queue = new CustomQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);

        queue.display();

        System.out.println(queue.remove());
        queue.display();
    }
}
