public class LongestBinarySubSequenceLessThanOrEqualToK {

    public int longestSubsequence(String s, int k) {
        return helper(s, 0, new StringBuilder(), k);
    }

    public int helper(String s, int i, StringBuilder sb, int k) {

        if(i == s.length()) {
            return 0;
        }
        int take = 0;

        sb.append(s.charAt(i));
        String str = sb.toString();

        if(str.length() <= 31) {
            int num = Integer.parseInt(str, 2);
            if(num <= k) {
                take = 1 + helper(s, i + 1, sb, k);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        int not = helper(s, i + 1, sb, k);
        return Math.max(take, not);
    }
}