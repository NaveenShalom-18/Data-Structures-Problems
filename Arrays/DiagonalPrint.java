package Arrays;

import java.util.Scanner;

public class DiagonalPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int k = 0, j = i;
            while (j >= 0 && k < m) {
                System.out.print(arr[k++][j--] + " ");
            }
        }

        for (int i = 1; i < m; i++) {
            int k = i, j = n - 1;
            while (k < m && j >= 0) {
                System.out.print(arr[k++][j--] + " ");
            }
        }

        sc.close();
    }
}
