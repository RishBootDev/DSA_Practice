import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),
                    map.getOrDefault(s.charAt(i), 0) +1);
        }

        int oddCount = 0;
        for(Integer ent : map.values()) {
            if(ent % 2 == 1) oddCount ++;
        }

        if(oddCount > k) return false;
        return true;
    }
}
