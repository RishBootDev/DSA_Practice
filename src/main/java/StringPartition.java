import java.util.ArrayList;
import java.util.List;

public class StringPartition {

    List<String> ans;
    public void helper(String s, int i, int k, List<String> list) {
        if (k == 0) {
            if (i == s.length()) {
                ans.addAll(list);
            }
            return;
        }
        for (int j = i; j <= s.length() - k; j++) {
            list.add(s.substring(i, j + 1));
            helper(s, j + 1, k - 1, list);
            list.removeLast();
        }
    }

    public String answerString(String word, int numFriends) {
        this.ans = new ArrayList<>();
        helper(word, 0, numFriends, new ArrayList<>());
        ans.sort((s1, s2) ->  s2.compareTo(s1));
        return ans.getFirst();
    }

    public static void main(String[] args) {

        StringPartition obj = new StringPartition();

        String s = "abcd";
        int k = 2;
    }
}
