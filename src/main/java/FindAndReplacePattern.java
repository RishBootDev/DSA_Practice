import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        LinkedHashMap<Character, Integer> pat = new LinkedHashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            pat.put(pattern.charAt(i), pat.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        List<Integer> res = new ArrayList<>(pat.values());
        List<String> ans = new ArrayList<>();
        int count = 0;

        for(String word : words) {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }

            if(res.equals(new ArrayList<>(map.values())))
                ans.add(word);
        }

        return ans;

    }
}
