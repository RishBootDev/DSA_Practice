import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FindMirrorOfAString {

    public long calculateScore(String s) {

        Map<Character, Deque<Integer>> map = new HashMap<>();
        long score = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            char mirror = (char) ('z' - (c - 'a'));

            if (map.containsKey(mirror) && !map.get(mirror).isEmpty()) {
                int j = map.get(mirror).pop();
                score += (i - j);
            } else {
                map.putIfAbsent(c, new ArrayDeque<>());
                map.get(c).push(i);
            }
        }

        return score;
    }
}
