package Queues;

class QueueImplementation {
    private int s[];
    private int front, rear;
    QueueImplementation(int size) {
        s = new int[size];
        front = rear = -1;
    }
    void enqueue(int data) {
        if(rear == s.length - 1) {
            System.out.print("Queues.Queue is full");
        }
        else {
            if(front == -1) front = 0;
            s[++rear] = data;
        }
    }
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queues.Queue is empty");
        }
        else {
            System.out.println("Dequeued: " + s[front]);
            front++;
            if (front > rear) {
                front = rear = -1;
            }
        }

    }
    void display() {
        for(int i=front;i<=rear;i++) {
            System.out.print(s[i]+" ");
        }
        System.out.println();
    }
}
