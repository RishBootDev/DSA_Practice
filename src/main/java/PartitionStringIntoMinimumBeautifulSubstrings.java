import java.sql.Array;
import java.util.*;

public class PartitionStringIntoMinimumBeautifulSubstrings {

    /*
     a string is beautiful if :
     1. It does not contains leading zeroes
     2. binary representation of a number that is power of 5
     */

    // this is the dynamic programming approach
    Set<String> set;
    Map<String, Integer> map;
    public int minimumBeautifulSubstrings(String s) {
        this.set = new HashSet<>();
        this.map = new HashMap<>();
        for (int i = 0; i <= 15; i++) {
            long c = (long)Math.pow(5, i);
            this.set.add(Long.toBinaryString(c));
        }
        int ans = helper(s, 0, new StringBuilder(), new ArrayList<>());
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    public int helper(String s, int i, StringBuilder sb, List<String> list) {
         if(i == s.length()) {
              if(!list.isEmpty() && check(s, list)) {
                  System.out.println(list);
                  return list.size();
              }
              return Integer.MAX_VALUE;
         }
         String key = i + ", " + sb.toString() + ", " + list;

         if(map.containsKey(key)) return map.get(key);
         int first = Integer.MAX_VALUE;
         sb.append(s.charAt(i));
         if(this.set.contains(sb.toString()) && !sb.toString().startsWith("0")) {
             list.add(sb.toString());
             first = helper(s, i + 1, new StringBuilder(), list);
             list.removeLast();
         }
         int second = helper(s, i + 1, sb, list);
         sb.deleteCharAt(sb.length() - 1);

         int ans = Math.min(first, second);
         map.put(key, ans);
         return ans;
    }

    public boolean check(String s, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
        }
        return sb.toString().equals(s);
    }

    public static void main(String[] args) {
        PartitionStringIntoMinimumBeautifulSubstrings ob = new PartitionStringIntoMinimumBeautifulSubstrings();
        System.out.println(ob.minimumBeautifulSubstrings("1011"));
        System.out.println("-------------------------------------------------------");
        System.out.println(ob.minimumBeautifulSubstrings("111"));
    }
}
