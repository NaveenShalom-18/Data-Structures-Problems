package Recursion;

import java.util.Scanner;

public class DescendingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        printDescendingNumbers(arr, n-1);
    }
    public static void printDescendingNumbers(int arr[], int index) {
        if(index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        printDescendingNumbers(arr, index-1);
    }
}
