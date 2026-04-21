import java.util.*;

public class AlertUsingSameKeyCardsLeetcode {

    public List<String> alertNames(String[] keyName, String[] keyTime) {

        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < keyName.length; i++) {
            if(map.containsKey(keyName[i])) {
                String t1 = map.get(keyName[i]);
                String t2 = map.get(keyTime[i]);

                if(alert(t1, t2)) {
                    set.add(keyName[i]);
                }
                map.put(keyName[i],keyTime[i]);
            }else map.put(keyName[i], keyTime[i]);
        }

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public boolean alert(String t1, String t2) {

        int h1 = Integer.parseInt(t1.substring(0, 2));
        int m1 = Integer.parseInt(t1.substring(2));

        int h2 = Integer.parseInt(t2.substring(0, 2));
        int m2 = Integer.parseInt(t2.substring(2));

        int time1 = h1 * 60 + m1;
        int time2 = h2 * 60 + m2;

        int diff;

        if (time2 >= time1) {
            diff = time2 - time1;
        } else {
            diff = (24 * 60 - time1) + time2;
        }
        return diff <= 60;
    }
}
