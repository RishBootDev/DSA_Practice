public class MaximumProductOfLengthOfTwoPalindromicSubsequences {

    public int maxProduct(String s) {
        return helper(s, 0, new StringBuilder(), new StringBuilder());
    }
    public int helper(String s, int i, StringBuilder s1, StringBuilder s2) {
        if(i == s.length()) {
            if(isPalindrome(s1.toString()) && isPalindrome(s2.toString())) {
                return s1.length() * s2.length();
            }
            return Integer.MIN_VALUE;
        }

        // option 1
        s1.append(s.charAt(i));
        int first = helper(s, i + 1, s1, s2);
        s1.deleteCharAt(s1.length() - 1);

        // option 2
        s2.append(s.charAt(i));
        int second = helper(s, i + 1, s1, s2);
        s2.deleteCharAt(s2.length() - 1);

        // third option
        int third = helper(s, i + 1, s1, s2);
        return Math.max(Math.max(first, third), second);
    }
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}
