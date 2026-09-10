import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MapSum {

    private Map<String , Integer> map;
    public MapSum() {
          map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (map.containsKey(key)) map.put(key, map.get(key) + val);
        else map.put(key, val);
    }

    public int sum(String prefix) {

        int sum = 0;
        for (Map.Entry<String, Integer> ent : map.entrySet()) {
            String key = ent.getKey();

            if (key.startsWith(prefix)) {
                sum += ent.getValue();
            }
        }
        return sum;
    }
}
