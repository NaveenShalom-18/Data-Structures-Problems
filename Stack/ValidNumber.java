package Stack;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(validNumer(s)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    public static boolean validNumer(String s) {
        boolean eSeen = false, numSeen = false, numAfterSeen = false, dotSeen = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                numSeen = true;
                numAfterSeen = true;
            }
            else if(c == '.') {
                if(dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }
            else if(c == 'e' || c == 'E') {
                if(!numSeen) return false;
                eSeen = true;
                numAfterSeen = false;
            }
            else if(c == '+' || c == '-') {
                if(i!=0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
            }
            else return false;
        }
        return numSeen && numAfterSeen;
    }
}
