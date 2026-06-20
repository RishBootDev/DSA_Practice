public class MatchSticksToSquare {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for(int c : matchsticks) sum += c;

        return helper(matchsticks, 0, 0, 0, 0, 0, sum);

    }
    public boolean helper(int [] match, int i, int a, int b, int c, int d, int sum) {
        if(i == match.length) {
            if (a == b && b == c && c == d && (a + b + c + d) == sum) {
                return true;
            }
            return false;
        }

        // take a
        boolean at = helper(match, i + 1, a + match[i], b, c, d, sum);
        // tabe b
        boolean bt = helper(match, i + 1, a, b + match[i], c, d, sum);
        // take c
        boolean ct = helper(match, i + 1, a, b, c + match[i], d, sum);
        // take d
        boolean dt = helper(match, i + 1, a, b, c, d + match[i], sum);

        return at || bt || ct || dt;
    }
}
