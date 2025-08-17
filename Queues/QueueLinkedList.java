package Queues;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}

class QueueLinkedList{
    ListNode front;
    ListNode rear;

    QueueLinkedList() {
        front = null;
        rear = null;
    }

    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);

        if(rear != null) {
            rear.next = newNode;
            rear = newNode;
            return ;
        }
        front = rear= newNode;

    }

    public int dequeue() {
        if(front == null) return -1;
        int val = front.val;
        front = front.next;
        return val;
    }

    public void display() {
        ListNode temp = front;
        while(temp != null) {
            System.out.print(temp.val +" ");
            temp = temp.next;
        }
    }

}