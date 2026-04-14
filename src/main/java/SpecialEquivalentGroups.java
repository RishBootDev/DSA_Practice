import java.util.*;

public class SpecialEquivalentGroups {

    public int numSpecialEquivGroups(String[] words) {

        Set<List<Character>> set = new HashSet<>();

        for (String word : words) {
            List<Character> even = new ArrayList<>();
            List<Character> odd = new ArrayList<>();

            for (int i = 0; i < word.length(); i+=2) {
                even.add(word.charAt(i));
            }
            for (int i = 1; i < word.length(); i+=2) {
                odd.add(word.charAt(i));
            }
            Collections.sort(even);
            Collections.sort(odd);
            List<Character> list = new ArrayList<>(even);
            list.addAll(odd);
            set.add(list);
        }

        return set.size();
    }
}
