import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareFreqBySmallestCharacter {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int qFreq = countSmallerCharacter(queries[i]);
            int count = 0;

            for (String word : words) {
                int wFreq = countSmallerCharacter(word);
                if (wFreq > qFreq) count++;
            }
            ans[i] = count;
        }

        return ans;
    }

    public int countSmallerCharacter(String word) {

        char min = Character.MAX_VALUE;
        int freq = 0;
        for (char c : word.toCharArray()) {
            if (c < min) {
                min = c;
                freq = 1;
            }
            else if (c == min) {
                freq++;
            }
        }
        return freq;
    }
}
