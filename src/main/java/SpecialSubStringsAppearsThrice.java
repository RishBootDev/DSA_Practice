import java.util.ArrayList;
import java.util.List;

public class SpecialSubStringsAppearsThrice {

        public int maximumLength(String s) {

            List<Integer>[] groups = new ArrayList[26];
            for (int i = 0; i < 26; i++) groups[i] = new ArrayList<>();

            int i = 0;
            while (i < s.length()) {
                int j = i;
                while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
                groups[s.charAt(i) - 'a'].add(j - i);
                i = j;
            }

            int ans = -1;

            for (List<Integer> list : groups) {
                if (list.isEmpty()) continue;

                list.sort((a, b) -> b - a);

                int L1 = list.get(0);
                int L2 = list.size() > 1 ? list.get(1) : 0;
                int L3 = list.size() > 2 ? list.get(2) : 0;

                ans = Math.max(ans, L1 - 2);
                ans = Math.max(ans, Math.min(L1 - 1, L2));
                ans = Math.max(ans, L3);
            }

            return ans > 0 ? ans : -1;
        }
    }

