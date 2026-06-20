public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
       return helper(s, '#', 0);
    }
    public int helper(String s, char prev, int i) {

        if (i == s.length()) {
            return 0;
        }

        int flip = Integer.MAX_VALUE;
        int not = Integer.MAX_VALUE;

        if (prev == '#') {

            not = helper(s, s.charAt(i), i + 1);

            char flipped = s.charAt(i) == '0' ? '1' : '0';
            flip = helper(s, flipped, i + 1) + 1;

        } else if (prev == '0') {
            not = helper(s, s.charAt(i), i + 1);
            char flipped = s.charAt(i) == '0' ? '1' : '0';
            flip = helper(s, flipped, i + 1) + 1;

        } else {
            if (s.charAt(i) == '1') {
                not = helper(s, '1', i + 1);
            } else {
                flip = helper(s, '1', i + 1) + 1;
            }
        }

        return Math.min(flip, not);
    }
}
