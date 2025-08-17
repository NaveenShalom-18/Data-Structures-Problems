package BackTracking;

import java.util.*;

public class NumbersBetween {
    public static boolean backtrack(int[] arr, int n) {
        if (n == 0) return true;

        int len = arr.length;
        for (int i = 0; i < len - n - 1; i++) {
            if (arr[i] == 0 && arr[i + n + 1] == 0) {
                arr[i] = n;
                arr[i + n + 1] = n;

                if (backtrack(arr, n - 1)) return true;

                // Backtrack
                arr[i] = 0;
                arr[i + n + 1] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[2 * n];

        if (backtrack(arr, n)) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Not Possible");
        }
    }
}
