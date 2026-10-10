import java.math.BigInteger;

public class DivisibilityArrayOfAString {

    public int[] divisibilityArray(String word, int m) {

        int ans[] = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            BigInteger bb = new BigInteger(word.substring(0, i + 1));
            if(bb.mod(new BigInteger(String.valueOf(m))).equals(BigInteger.ZERO)) {
                ans[i] = 1;
            }else ans[i] = 0;
        }


        return ans;
    }
}
