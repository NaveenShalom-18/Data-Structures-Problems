package Recursion;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sumOfNumbers(arr, 0 );
        System.out.println(sum);
    }
    public static int sumOfNumbers(int arr[], int index) {
        if(index == arr.length) {
            return 0;
        }
        return arr[index] + sumOfNumbers(arr, index+1);
    }
}
