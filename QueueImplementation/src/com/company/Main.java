package com.company;

public class Main {

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(4);

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        //by default the unassigned value will be assigned to 0
        queue.display();
        queue.deQueue();
        System.out.println();
        queue.display();
    }
}

class QueueUsingArray {
    int front_q, rear_q;
    int queueSize;
    int[] q1;

    public QueueUsingArray(int size){
        this.queueSize = size;
        q1 = new int[queueSize];
    }

    void enQueue(int value){
        if(rear_q == queueSize){
            System.out.println("Queue size is full, cannot insert values");
        } else {
            q1[rear_q] = value; //adding the value to the queue
            rear_q++; //incrementing the queue position
        }
    }

    void deQueue(){
        if(rear_q == 0){
            System.out.println("Queue is already empty.");
        } else {
            for(int i=0;i<queueSize-1;i++){
                q1[i] = q1[i+1]; //deleting the first element and switching 2nd element to 1st respectively.
            }
            rear_q--; //decrementing the queue position
        }
    }

    void display(){
        if(rear_q == 0){
            System.out.println("Queue is empty, nothing to display!");
        } else {
            for(int i=0;i<queueSize;i++){
                System.out.print(q1[i]+" ");
            }
        }
    }
}
