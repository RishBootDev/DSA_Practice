import java.util.HashMap;
import java.util.Map;

public class CountVowelPermutation {

    private Map<String, Long> map;

    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        long ans = 0;

        ans += helper('a', n - 1);
        ans += helper('e', n - 1);
        ans += helper('i', n - 1);
        ans += helper('o', n - 1);
        ans += helper('u', n - 1);

        return (int) ans;
    }

    public long helper(char ch, int rem) {

        if (rem == 0)
            return 1;

        String key = ch + " " + rem;
        if(map.containsKey(key)) return map.get(key);

        long ans = 0;

        if (ch == 'a') {
            ans += helper('e', rem - 1);
        }
        else if (ch == 'e') {
            ans += helper('a', rem - 1);
            ans += helper('i', rem - 1);
        }
        else if (ch == 'i') {
            ans += helper('a', rem - 1);
            ans += helper('e', rem - 1);
            ans += helper('o', rem - 1);
            ans += helper('u', rem - 1);
        }
        else if (ch == 'o') {
            ans += helper('i', rem - 1);
            ans += helper('u', rem - 1);
        }
        else {
            ans += helper('a', rem - 1);
        }
        map.put(key, ans);
        return ans;
    }
}
