import java.util.Scanner;

public class GravityGuy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            String lane1 = sc.next();
            String lane2 = sc.next();

            System.out.println(helper(lane1, lane2, true, 0) ||
                    helper(lane1, lane2, false, 0) ? "YES" : "NO");
        }
    }

    public static boolean helper(String lane1, String lane2, boolean isLane1, int i) {

        if(i == lane1.length()) {
            return true;
        }

        if(isLane1) {

            if(lane1.charAt(i) == '#') {
                return false;
            }

            boolean ans = false;

            if(i + 1 < lane1.length() && lane1.charAt(i + 1) == '.') {
                ans |= helper(lane1, lane2, true, i + 1);
            }

            if(lane2.charAt(i) == '.') {
                ans |= helper(lane1, lane2, false, i);
            }

            if(i + 1 < lane1.length() && lane2.charAt(i + 1) == '.') {
                ans |= helper(lane1, lane2, false, i + 1);
            }

            return ans;

        } else {

            if(lane2.charAt(i) == '#') {
                return false;
            }

            boolean ans = false;

            if(i + 1 < lane1.length() && lane2.charAt(i + 1) == '.') {
                ans |= helper(lane1, lane2, false, i + 1);
            }

            if(lane1.charAt(i) == '.') {
                ans |= helper(lane1, lane2, true, i);
            }

            if(i + 1 < lane1.length() && lane1.charAt(i + 1) == '.') {
                ans |= helper(lane1, lane2, true, i + 1);
            }

            return ans;
        }
    }
}