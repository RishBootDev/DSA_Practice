import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApplyOperationsTOMakeStringEmpty {


    // in this question we have to remove the first occurence of each character
    public String lastNonEmptyString(String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }

        int temp = 0;
        for(int c : map.values()) {
           sb.deleteCharAt(c - temp);
        }

        return sb.toString();
    }
}
