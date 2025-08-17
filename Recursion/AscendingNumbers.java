package Recursion;

import java.util.Scanner;

public class AscendingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        printAscendingNumbers(arr, 0);
    }
    public static void printAscendingNumbers(int arr[], int index) {
        if(index == arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        printAscendingNumbers(arr, index+1);
    }
}