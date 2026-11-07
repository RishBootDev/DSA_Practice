import java.util.HashSet;
import java.util.Set;

public class SubstringsSetUsingRecursion {

    private Set<String> set;
    public int maxUniqueSplit(String s) {
        this.set = new HashSet<>();
        helper(s, 0, new StringBuilder());
        System.out.println(set);
        return set.size();
    }

    public void helper(String s, int i, StringBuilder sb) {

        if(i == s.length()) {
            return;
        }

        sb.append(s.charAt(i));
        set.add(sb.toString());
        helper(s, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        helper(s, i + 1, new StringBuilder());
    }

    public static void main(String[] args) {
        SubstringsSetUsingRecursion ob = new SubstringsSetUsingRecursion();
        System.out.println(ob.maxUniqueSplit("ababccc"));
    }
}
