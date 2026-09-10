import java.util.Map;

public class AuthenticationManager {

    private Map<String, Integer> map;
    private int ttl;
    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
         map.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.get(tokenId) >= currentTime) {
            map.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
         int count = 0;
         for(Map.Entry<String, Integer> ent : map.entrySet()) {
             if(ent.getValue() >= currentTime) count++;
         }
         return count;
    }
}
