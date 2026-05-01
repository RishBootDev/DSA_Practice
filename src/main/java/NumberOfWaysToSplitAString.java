import java.util.HashSet;
import java.util.Set;

public class NumberOfWaysToSplitAString {

    public int numSplits(String s) {

        int[] pre = new int[s.length()];
        int[] suff = new int[s.length()];

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            pre[i] = set.size();
        }

        set = new HashSet<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            suff[i] = set.size();
        }

        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            if (pre[i] == suff[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
