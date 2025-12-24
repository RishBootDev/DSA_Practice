
import java.util.HashMap;
import java.util.Map;

public class AnagramHackerrank {

    public static int anagram(String s) {

        if(s.length()%2!=0) return -1;

        StringBuilder part1=new StringBuilder();
        StringBuilder part2=new StringBuilder();

        int mid=s.length()/2;
        for (int i = 0; i < s.length(); i++) {
            if(i<mid) part1.append(s.charAt(i));
            else part2.append(s.charAt(i));
        }

        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();

        for (int i = 0; i < part1.length(); i++) {
            map1.put(part1.charAt(i),map1.getOrDefault(part1.charAt(i),0)+1);
            map2.put(part2.charAt(i),map2.getOrDefault(part2.charAt(i),0)+1);
        }

        int changes = 0;

        for (char ch : map1.keySet()) {
            int freq1 = map1.get(ch);
            int freq2 = map2.getOrDefault(ch, 0);

            if (freq1 > freq2) {
                changes += freq1 - freq2;
            }
        }


        return changes;
    }
}
