import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllSubstringofK {

    public boolean hasAllCodes(String s, int k) {

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            sb.append(s.charAt(i));
        }
        set.add(sb.toString());

        for (int i = k; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
            set.add(sb.toString());
        }
        return set.size() == Math.pow(k, 2);
    }
}
