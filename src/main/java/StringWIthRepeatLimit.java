import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringWIthRepeatLimit {

    public String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.ch - p1.ch);

        for (Map.Entry<Character, Integer> ent : map.entrySet()) {
            pq.add(new Pair(ent.getKey(), ent.getValue()));
        }
        Pair pair = pq.poll();
        assert pair != null;
        char prev = pair.ch;
        int rl = repeatLimit;

        StringBuilder ans = new StringBuilder();
        ans.append(prev);
        pair.freq--;
        rl--;

        if (pair.freq > 0) pq.add(pair);

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            if (p.ch == prev && rl == 0) {

                if (pq.isEmpty()) break;
                Pair x = pq.poll();
                ans.append(x.ch);
                x.freq--;
                if (x.freq > 0) pq.add(x);
                pq.add(p);
                prev = x.ch;
                rl = repeatLimit - 1;

            } else {
                ans.append(p.ch);
                p.freq--;
                if (p.ch == prev) {
                    rl--;
                } else {
                    prev = p.ch;
                    rl = repeatLimit - 1;
                }
                if (p.freq > 0) pq.add(p);
            }
        }

        return ans.toString();
    }

    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}