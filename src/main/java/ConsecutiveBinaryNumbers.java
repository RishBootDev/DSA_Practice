import java.math.BigInteger;

public class ConsecutiveBinaryNumbers {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
    }

    public int concatenatedBinary(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <=n; i++) {
            sb.append(Integer.toBinaryString(i));
        }

        BigInteger bb = new BigInteger(sb.toString(),2);
        BigInteger ans = bb.mod(new BigInteger(String.valueOf(MOD)));

        return ans.intValue();
    }
}
