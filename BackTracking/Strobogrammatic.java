package BackTracking;

import java.util.*;

public class Strobogrammatic {

    public static List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }

    private static List<String> build(int n, int totalLength) {
        if (n == 0) return new ArrayList<>(List.of(""));
        if (n == 1) return new ArrayList<>(List.of("0", "1", "8"));

        List<String> prev = build(n - 2, totalLength);
        List<String> result = new ArrayList<>();

        for (String middle : prev) {
            if (n != totalLength) {
                result.add("0" + middle + "0");
            }
            result.add("1" + middle + "1");
            result.add("6" + middle + "9");
            result.add("9" + middle + "6");
            result.add("8" + middle + "8");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 2; // change this to any number
        List<String> res = findStrobogrammatic(n);
        System.out.println("Strobogrammatic numbers of length " + n + ":");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
