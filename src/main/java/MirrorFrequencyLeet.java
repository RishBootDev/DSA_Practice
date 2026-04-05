import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MirrorFrequencyLeet {

        public int mirrorFrequency(String s) {

            Map<Character, Integer> map = new HashMap<>();

            for(int i = 0;i< s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            Set<Character> track = new HashSet<>();
            int ans = 0;

            //  System.out.println(map);

            for(Map.Entry<Character, Integer> ent : map.entrySet()) {
                char key = ent.getKey();
                char temp;
                int c = ent.getValue();

                int m;

                if(key >='0' && key <='9'){
                    temp = (char)('9' - (key - '0'));
                    //   System.out.println(temp);
                    if(map.get(temp) == null) m = 0;
                    else  m = map.get(temp);
                }
                else{
                    temp = (char)('z' - (key-'a'));
                    if(map.get(temp) == null) m = 0;
                    else  m = map.get(temp);
                }

                if(!track.contains(key)){
                    ans += Math.abs(m - c);
                    track.add(key);
                    track.add(temp);
                }
            }

            return ans;

        }

}
