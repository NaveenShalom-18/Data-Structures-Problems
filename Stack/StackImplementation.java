package Stack;

import java.util.*;
class Stack {
    int top;
    int size;
    int stack[];
    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    void push(int data) {
        if(isFull()) {
            System.out.print("Stack.Stack is Full");
        }
        stack[++top] = data;
    }
    int pop() {
        if(isEmpty()) {
            System.out.print("Stack.Stack is Empty");
            return -1;
        }
        return stack[top--];
    }
    void display() {
        for(int i=top;i>=0;i--) {
            System.out.print(stack[i]+" ");
        }
    }
    boolean isFull() {
        return (top == size - 1);
    }
    boolean isEmpty() {
        return (top == -1);
    }
}
public class StackImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack(5);
        s.push(2);
        s.push(3);
        s.push(6);
        s.push(8);
        s.display();
    }
}