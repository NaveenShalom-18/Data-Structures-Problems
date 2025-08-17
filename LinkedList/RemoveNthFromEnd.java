package LinkedList;

import java.util.*;
class Node {
    int data;
    Node next;
    Node(int newdata) {
        data = newdata;
        next = null;
    }
}
class RemoveNthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        String arr[] = str.split(" ");
        Node head = null;
        Node tail = null;
        for(int i=0;i<arr.length;i++) {
            int num = Integer.parseInt(arr[i]);
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
        int cnt = count(head);
        int rem = cnt - n;
        Node ans = remove(head, rem);
        List<Integer> lst = new ArrayList<>();
        if(cnt == n) {
            head = head.next;
        }
        while(head != null) {
            lst.add(head.data);
            head = head.next;
        }
        System.out.print(lst);
    }
    public static Node remove(Node head, int rem) {
        Node temp = head;
        if(head == null || head.next==null) {
            return null;
        }
        while(rem > 1) {
            temp = temp.next;
            rem--;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static int count(Node head) {
        Node temp = head;
        int cnt = 0;
        while(temp!=null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
