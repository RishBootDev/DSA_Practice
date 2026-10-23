import java.util.HashSet;
import java.util.Set;

public class WildCardMatching {

    // this is the correct recursion, let me memoize this
    public boolean isMatch(String s, String p) {
        if(p.isEmpty() && s.isEmpty()) return true;
        if(s.isEmpty()) {
            Set<Character> set = new HashSet<>();
            for(int  i= 0; i < p.length(); i++) {
                set.add(p.charAt(i));
             }
            if(set.contains('*') && set.size() == 1) return true;
            return false;
        }
        return helper(s, 0, p, 0, false);
    }
    public boolean helper(String s, int i, String p, int j, boolean flag) {

        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        if (flag) {
            boolean con = false;
            boolean tr = helper(s, i, p, j + 1, false);
            boolean br = false;

            if (i < s.length()) {
                con = helper(s, i + 1, p, j, true);
                br = helper(s, i + 1, p, j + 1, false);
            }
            return con || br || tr;
        } else {
            if (i == s.length()) {
                if (p.charAt(j) == '*') {
                    return helper(s, i, p, j + 1, false);
                }
                return false;
            }
            if (p.charAt(j) == '?') {
                return helper(s, i + 1, p, j + 1, false);
            } else if (p.charAt(j) == '*') {
                return helper(s, i, p, j, true);
            } else if (s.charAt(i) != p.charAt(j)) {
                return false;
            } else {
                return helper(s, i + 1, p, j + 1, false);
            }
        }
    }

    public static void main(String[] args) {
        WildCardMatching wt = new WildCardMatching();
        System.out.println(wt.isMatch("adceb" , "*a*b"));
        System.out.println(wt.isMatch("a", "?"));
        System.out.println(wt.isMatch("abcabczzzde", "*abc???de*"));
       // System.out.println(wt.isMatch("fljfadfjkdf", "*********????*******"));

    }
}
