import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionStringIntoMinimumBeautifulSubstrings {

    /*
     a string is beautiful if :
     1. It does not contains leading zeroes
     2. binary representation of a number that is power of 5
     */

    // this is the backtracking approach
    Set<String> set;
    int min;
    public int minimumBeautifulSubstrings(String s) {
        this.set = new HashSet<>();
        this.min = Integer.MAX_VALUE;
        for (int i = 0; i <= 15; i++) {
            long c = (long)Math.pow(5, i);
            this.set.add(Long.toBinaryString(c));
        }
        helper(s, 0, new StringBuilder(), new ArrayList<>());
        return min == 0?0:min;
    }

    public void helper(String s, int i, StringBuilder sb, List<String> list) {
         if(i == s.length()) {
              if(!list.isEmpty() && check(s, list)) {
                  System.out.println(list);
                  this.min = Math.min(min, list.size());
              }
              return;
         }
         sb.append(s.charAt(i));
         if(this.set.contains(sb.toString()) && !sb.toString().startsWith("0")) {
             list.add(sb.toString());
             helper(s, i + 1, new StringBuilder(), list);
             list.removeLast();
         }
         helper(s, i + 1, sb, list);
         sb.deleteCharAt(sb.length() - 1);
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
        ob.minimumBeautifulSubstrings("1011");
        System.out.println(ob.min);
        System.out.println("-------------------------------------------------------");
        ob.minimumBeautifulSubstrings("111");
        System.out.println(ob.min);
    }
}
