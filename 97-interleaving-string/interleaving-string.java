class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        this.dp = new Boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) return false;

        return helper(s1, 0, s2, 0, s3, new StringBuilder());
    }

    public boolean helper(String s1, int i, String s2, int j,
                          String s3, StringBuilder sb) {

        if (sb.length() > s3.length()) return false;

        for (int k = 0; k < sb.length(); k++) {
            if (sb.charAt(k) != s3.charAt(k)) return false;
        }

        if (sb.length() == s3.length()) return true;
        if(dp[i][j] != null) return false;
        boolean ans = false;

        if (i < s1.length()) {
            sb.append(s1.charAt(i));
            ans |= helper(s1, i + 1, s2, j, s3, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (j < s2.length()) {
            sb.append(s2.charAt(j));
            ans |= helper(s1, i, s2, j + 1, s3, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        return dp[i][j] = ans;
    }
}