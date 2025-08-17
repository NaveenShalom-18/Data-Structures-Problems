package DynammicProgramming;

import java.util.*;
public class RegexMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.print(isMatch(s,p));
    }
    public static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=2;i<=p.length();i++) {
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
        }
        for(int i=1;i<=s.length();i++) {
            for(int j=1;j<=p.length();j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    char prev = p.charAt(j - 2);
                    if (prev == s.charAt(i-1) || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}