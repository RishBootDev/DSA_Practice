import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTheStringAnagrams {

    public int minSteps(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        int count = 0;

        HashSet<Character> set = new HashSet<>();
        for(Map.Entry<Character, Integer> ent: map1.entrySet()) {
            char key = ent.getKey();
            int freq1 = ent.getValue();
            int freq2 = 0;
            if(map2.containsKey(key)) {
                freq2 = map2.get(key);
            }
            set.add(key);
            count += Math.abs(freq1 - freq2);
        }

        for(Map.Entry<Character, Integer> ent: map2.entrySet()) {

            int key = ent.getKey();
            if(!set.contains(key)){
                int freq1 = ent.getValue();
                int freq2 = 0;
                if(map2.containsKey(key)) {
                    freq2 = map2.get(key);
                }

                count += Math.abs(freq1 - freq2);
            }
        }



        return count;

    }
}
