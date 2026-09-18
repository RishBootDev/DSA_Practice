import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, 0, new StringBuilder(), set, new ArrayList<>());
    }

    public List<String> helper(String s, int i, StringBuilder sb,
                               Set<String> set, List<String> list) {
        List<String> ans = new ArrayList<>();

        if(i == s.length()) {
            if(!sb.isEmpty() && set.contains(sb.toString())) {
                list.add(sb.toString());
                StringBuilder tp = new StringBuilder();
                for(String str : list) {
                    tp.append(str).append(" ");
                }
                ans.add(tp.toString().trim());
                list.removeLast();
            }
            return ans;
        }
        sb.append(s.charAt(i));

        if(set.contains(sb.toString())) {
            // take
            list.add(sb.toString());
            ans.addAll(helper(s, i + 1, new StringBuilder(), set, list));
            list.removeLast();
            // not take
            ans.addAll(helper(s, i + 1, sb, set, list));
        } else {
            ans.addAll(helper(s, i + 1, sb, set, list));
        }
        return ans;
    }
}