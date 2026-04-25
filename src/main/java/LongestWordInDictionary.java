import java.util.Collections;
import java.util.List;

public class LongestWordInDictionary {

    public String findLongestWord(String s,
                                  List<String> dictionary) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        Collections.sort(dictionary);

        for (int j = 0; j < dictionary.size(); j++) {
            String str = dictionary.get(j);
            int i = 0;

            for (int k = 0; k < s.length(); k++) {
                if(i < str.length() && s.charAt(k) == str.charAt(i)) {
                    i++;
                }
            }

            if(i == str.length()) {
                if(max < str.length()) {
                    max = str.length();
                    ans = j;
                }
            }
        }
        return ans == -1? "": dictionary.get(ans);
    }
}
