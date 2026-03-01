import java.util.HashMap;
import java.util.Map;

public class GameWithString {

        public int minValue(String s, int k) {
            HashMap<Character, Integer> charFrequency = new HashMap<>();

            for(int i = 0; i < s.length(); i++) {
                charFrequency.put(s.charAt(i), charFrequency.getOrDefault(s.charAt(i), 0) + 1);
            }

            HashMap<Integer, Integer>intFrequency = new HashMap<>();
            int maxi = -1;

            for(Map.Entry<Character, Integer> it : charFrequency.entrySet()) {
                int tempInteger = it.getValue();
                maxi = Math.max(maxi, tempInteger);
                intFrequency.put(tempInteger, intFrequency.getOrDefault(tempInteger, 0) + 1);
            }

            while(maxi > 0 && k > 0) {
                int count = intFrequency.getOrDefault(maxi, 0);
                if(count != 0){
                    if(count >= k) {
                        intFrequency.put(maxi , count - k);
                        intFrequency.put(maxi - 1, intFrequency.getOrDefault(maxi - 1, 0) + k);
                        k = 0;
                    }
                    else {
                        k = k-count;
                        intFrequency.put(maxi, 0);
                        intFrequency.put(maxi - 1, intFrequency.getOrDefault(maxi - 1, 0) + count);
                    }
                }
                -- maxi;
            }

            int ans = 0;

            for(Map.Entry<Integer, Integer> it : intFrequency.entrySet()) {
                int key = it.getKey();
                int value = it.getValue();
                ans = ans + (key * key * value);
            }

            return ans;

        }

}
