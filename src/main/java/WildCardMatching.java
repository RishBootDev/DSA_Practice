import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WildCardMatching {

    Boolean[][][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1][2];
        return helper(s, 0, p, 0, false);
    }

    public boolean helper(String s, int i, String p, int j, boolean flag) {

        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (j == p.length()) {
            return false;
        }

        int f = flag ? 1 : 0;

        if (dp[i][j][f] != null) {
            return dp[i][j][f];
        }

        boolean ans = false;

        if (flag) {
            boolean tr = helper(s, i, p, j + 1, false);
            boolean con = false;

            if (i < s.length()) {
                con = helper(s, i + 1, p, j, true);
            }

            ans = con || tr;

        } else {
            if (i == s.length()) {
                if (p.charAt(j) == '*') {
                    ans = helper(s, i, p, j + 1, false);
                }
            } else if (p.charAt(j) == '?') {
                ans = helper(s, i + 1, p, j + 1, false);

            } else if (p.charAt(j) == '*') {
                ans = helper(s, i, p, j, true);

            } else if (s.charAt(i) == p.charAt(j)) {
                ans = helper(s, i + 1, p, j + 1, false);
            }
        }

        dp[i][j][f] = ans;
        return ans;
    }


    public static void main(String[] args) {
         WildCardMatching wt = new WildCardMatching();
        System.out.println(wt.isMatch("adceb" , "*a*b"));
        System.out.println(wt.isMatch("a", "?"));
        System.out.println(wt.isMatch("abcabczzzde", "*abc???de*"));
       // System.out.println(wt.isMatch("fljfadfjkdf", "*********????*******"));

    }
}
