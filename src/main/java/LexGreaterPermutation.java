import java.util.List;

// this is the bruteforce approach to solve the question but it is too expensive to be used
public class LexGreaterPermutation {

        String ans = "";

        public String lexGreaterPermutation(String s, String target) {
            permutations(s, new StringBuilder(), new boolean[s.length()], target);
            return ans;
        }

        public void permutations(String s, StringBuilder sb, boolean[] vis, String target) {

            if (sb.length() == s.length()) {
                String str = sb.toString();

                if (str.compareTo(target) > 0) {
                    if (ans.equals("") || str.compareTo(ans) < 0) {
                        ans = str;
                    }
                }

                return;
            }

            for (int j = 0; j < s.length(); j++) {

                if (!vis[j]) {
                    vis[j] = true;
                    sb.append(s.charAt(j));
                    permutations(s, sb, vis, target);
                    sb.deleteCharAt(sb.length() - 1);
                    vis[j] = false;
                }
            }
        }

}
