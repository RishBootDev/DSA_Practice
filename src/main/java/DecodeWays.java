class DecodeWays {


    // this is a pure recursion and i got time limit exceeded here
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    public int helper(String s, int i) {

        if(i == s.length()) {
            return 1;
        }

        if(s.charAt(i) == '0') {
            return 0;
        }

        int count = helper(s, i + 1);

        if(i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');
            if(num >= 10 && num <= 26) {
                count += helper(s, i + 2);
            }
        }
        return count;
    }
}