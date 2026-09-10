import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> ans = new ArrayList<>();

        first :
        for(String word : words1) {
            for (String str : words2) {
                if (!check(word, str)) {
                    continue first;
                }
            }
            ans.add(word);
        }
        return ans;
    }
    public boolean check(String word1, String word2) {

        int i = 0;
        for (int j = 0; j < word1.length(); j++) {
            if(i == word2.length()) return true;
            if(word1.charAt(j) == word2.charAt(i) + 1) {
                i ++;
            }
        }
        if(i == word2.length()) return true;
        return false;
    }
}
