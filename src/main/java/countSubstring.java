import java.util.HashMap;
import java.util.Map;

public class countSubstring {
    public int countSubstring(String s) {
        // code here

        Map<Character,Integer> map=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int ans=0;
        for (Map.Entry<Character,Integer> ent: map.entrySet()) {
            int val=(ent.getValue()*(ent.getValue()+1))/2;

            ans+=val;
        }

        return ans;
    }

}
