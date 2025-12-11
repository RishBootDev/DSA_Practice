
//
//Given a string s with repeated characters, the task is to rearrange characters in a string such that no two adjacent characters are the same.
//Note: The string has only lowercase English alphabets and it can have multiple solutions. Return any one of them. If there is no possible solution, then print empty string ("").


import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {

    static String rearrangeString(String s) {
        int n = s.length();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());

        StringBuilder res = new StringBuilder();

        Map.Entry<Character, Integer> prev = new AbstractMap.SimpleEntry<>('#', -1);

        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> p = pq.poll();
            res.append(p.getKey());

            if (prev.getValue() > 0)
                pq.offer(prev);

            prev = new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue() - 1);
        }

        if (res.length() != n)
            return "";

        return res.toString();
    }
}
