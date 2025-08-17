package Arrays;

import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int leftmax[] = new int[n];
        int rightmax[] = new int[n];
        leftmax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i-1], arr[i]);
//            System.out.print(leftmax[i] + " ");
        }
        rightmax[n-1] = arr[n-1];
        for(int i = n-2; i >=0 ; i--) {
            rightmax[i] = Math.max(rightmax[i+1], arr[i]);
//            System.out.print(rightmax[i] + " ");
        }
        int water = 0;
        for(int i=0;i<n;i++) {
            water += Math.min(leftmax[i], rightmax[i]) - arr[i];
        }
        System.out.println(water);
    }
}
