package HashTable;
import java.util.*;

public class LongestStrictBitonicSubsequence {

    public static List<Integer> longestStrictBitonic(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];      // length of LIS ending at i
        int[] lds = new int[n];      // length of LDS starting at i
        int[] prevLIS = new int[n];  // to reconstruct LIS
        int[] nextLDS = new int[n];  // to reconstruct LDS

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        Arrays.fill(prevLIS, -1);
        Arrays.fill(nextLDS, -1);

        // Build LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + 1 == arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prevLIS[i] = j;
                }
            }
        }

        // Build LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] == arr[i] - 1 && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                    nextLDS[i] = j;
                }
            }
        }

        // Find peak index of max bitonic length
        int maxLen = 0;
        int peak = 0;
        for (int i = 0; i < n; i++) {
            int bitonicLength = lis[i] + lds[i] - 1;
            if (bitonicLength > maxLen) {
                maxLen = bitonicLength;
                peak = i;
            }
        }

        // Reconstruct the subsequence
        List<Integer> result = new ArrayList<>();

        // Add LIS part
        Stack<Integer> stack = new Stack<>();
        int i = peak;
        while (i != -1) {
            stack.push(arr[i]);
            i = prevLIS[i];
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        // Add LDS part (skip peak to avoid duplicate)
        i = nextLDS[peak];
        while (i != -1) {
            result.add(arr[i]);
            i = nextLDS[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> result = longestStrictBitonic(arr);
        System.out.println(result.size());
    }
}
