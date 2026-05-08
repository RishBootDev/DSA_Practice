import java.util.Arrays;

public class ReorderedPowerOfTwo {

    // pre computation is the key here for solving this question
    public boolean reorderedPowerOf2(int n) {

        String target = getFreq(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            if (target.equals(getFreq(power))) {
                return true;
            }
        }
        return false;
    }

    private String getFreq(int n) {

        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return Arrays.toString(freq);
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,13));
    }
}
