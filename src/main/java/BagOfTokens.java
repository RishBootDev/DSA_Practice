import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int ans = 0;
        int max = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                ans++;
                i++;
                max = Math.max(max, ans);
            } else if (ans > 0) {
                power += tokens[j];
                ans--;
                j--;
            } else {
                break;
            }
        }
        return max;
    }
}
