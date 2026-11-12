import java.util.*;

public class MinimumSubstringPartitionWithEqualCharacterFrequency {

    public int minimumSubstringsInPartition(String s) {
        Map<Character, Integer> map = new HashMap<>();
        return helper(s, 0, map);
    }
    public int helper(String s, int i, Map<Character, Integer> map) {
        if(i == s.length()) return 0;

        int first = Integer.MAX_VALUE;
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        if(check(map)) {
            first = helper(s, i + 1, new HashMap<>()) + 1;
        }
        int second = helper(s, i + 1, map);

        return Math.min(first , second);
    }

    public boolean check(Map<Character, Integer> map) {
       return new HashSet<>(map.values()).size() == 1;
    }

    public static void main(String[] args) {
        MinimumSubstringPartitionWithEqualCharacterFrequency ob =
                new MinimumSubstringPartitionWithEqualCharacterFrequency();

       // System.out.println(ob.minimumSubstringsInPartition("fabccddg"));

    }
}
