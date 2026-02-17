import java.util.HashMap;
import java.util.Map;

public class MinimumLengthOfString {

        public int minimumLength(String s) {

            Map<Character, Integer> map = new HashMap<>();

            for(int i =0;i<s.length();i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            }

            int count = 0;
            for(int x : map.values()){
                if(x%2!=0) count++;
                else count+=2;
            }
            return count;

        }
}
