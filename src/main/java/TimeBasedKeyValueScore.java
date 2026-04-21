import java.util.*;

public class TimeBasedKeyValueScore {

    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueScore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
       if(map.containsKey(key)){

           List<Pair> list = map.get(key);

           int i = 0;
           int j = list.size() - 1;
           String ans = "";

           while (i <= j) {
               int mid = i + (j - i) / 2;
               Pair pair = list.get(mid);

               if (pair.timestamp == timestamp) {
                   return pair.value;
               } else if (pair.timestamp < timestamp) {
                   ans = pair.value;
                   i = mid + 1;
               } else {
                   j = mid - 1;
               }
           }
           return ans;
       }else return "";
    }

    static class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
