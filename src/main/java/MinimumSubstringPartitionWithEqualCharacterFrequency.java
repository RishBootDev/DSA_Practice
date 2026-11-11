import java.util.*;

public class MinimumSubstringPartitionWithEqualCharacterFrequency {


    // the approach is correct but it is giving me tle
    Map<String, Integer> dp;
    public int minimumSubstringsInPartition(String s) {
        this.dp = new HashMap<>();
        return helper(s, 0, new StringBuilder(), new ArrayList<>());
    }
    public int helper(String s, int i, StringBuilder sb, List<String> list) {
        if(i == s.length()) {
            if(test(list, s)) {
                //System.out.println(list);
                return list.size();
            }
            return Integer.MAX_VALUE;
        }
        String key = i + ", " + list;
        int first = Integer.MAX_VALUE;
        if(dp.containsKey(key)) return dp.get(key);

        sb.append(s.charAt(i));
        if(check(sb)) {
            list.add(sb.toString());
            first = helper(s, i + 1, new StringBuilder(), list);
            list.removeLast();
        }
        int second = helper(s, i + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        int value = Math.min(first, second);
        dp.put(key, value);
        return value;
    }

    public boolean test(List<String> list, String n) {
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
        }
        return sb.toString().equals(n);
    }
    public boolean check(StringBuilder sb) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sb.length(); i++) {
            map.put(sb.charAt(i), map.getOrDefault(sb.charAt(i), 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }

    public static void main(String[] args) {
        MinimumSubstringPartitionWithEqualCharacterFrequency ob =
                new MinimumSubstringPartitionWithEqualCharacterFrequency();

       // System.out.println(ob.minimumSubstringsInPartition("fabccddg"));

    }
}
