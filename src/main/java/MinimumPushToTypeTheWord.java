import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumPushToTypeTheWord {

    public int minimumPushes(String word) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);
        for(Map.Entry<Character, Integer> ent : map.entrySet()) {
            Pair pair = new Pair(ent.getKey(), ent.getValue());
            pq.add(pair);
        }
        Map<Character, Integer> tm = new HashMap<>();
        int i = 1;

        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            char ch = pair.ch;
            int freq = pair.freq;
            tm.put(ch, i % 9);
            i++;
        }
        System.out.println(map);
        int ans = 0;
        for (int j = 0; j < word.length(); j++) {
            ans += tm.get(word.charAt(j));
        }
        return ans;
    }

    static class Pair{
         char ch;
         int freq;
         public Pair(char ch, int freq) {
             this.ch = ch;
             this.freq = freq;
         }
    }
}
