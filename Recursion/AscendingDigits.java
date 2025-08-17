package Recursion;

import java.util.Scanner;

public class AscendingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ascendingDigits(n,1);
    }
    public static void ascendingDigits(int n, int num) {
        if(num > n) return;
        System.out.print(num+" ");
        ascendingDigits(n,num+1);
    }
}
