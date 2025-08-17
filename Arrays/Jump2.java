package Arrays;

import java.util.*;

class Jump2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int n = str.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(jumpPathII(arr));
    }

    public static int jumpPathII(int arr[]) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= arr.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
