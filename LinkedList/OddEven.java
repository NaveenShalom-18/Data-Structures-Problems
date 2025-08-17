package LinkedList;

import java.util.*;
class OddTail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;
        for(int i=1;i<=n;i++) {
            int num = sc.nextInt();
            Node newnode = new Node(num);
            if(head == null) {
                head = newnode;
                tail = newnode;
            }
            else {
                tail.next = newnode;
                tail = newnode;
            }
        }
        head = reverse(head);
        Node temp = evenOdd(head);
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static Node reverse(Node head) {
        Node prev = null, curr = head, next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node evenOdd(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node odd = new Node(0);
        Node oddtail = odd;
        Node even = new Node(0);
        Node eventail = even;
        while(head != null) {
            if(head.data%2!=0) {
                oddtail.next = head;
                oddtail = head;
            }
            else {
                eventail.next = head;
                eventail = head;
            }
            head = head.next;
        }
        oddtail.next = null;
        eventail.next = odd.next;
        return even.next;
    }
}