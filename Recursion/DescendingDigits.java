package Recursion;

import java.util.Scanner;

public class DescendingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        descendingDigits(n);
    }
    public static void descendingDigits(int n) {
        if(n == 0) return;
        System.out.print(n + " ");
        descendingDigits(n-1);
    }
}
