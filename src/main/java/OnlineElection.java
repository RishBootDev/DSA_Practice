import java.util.HashMap;
import java.util.Map;



// this is the hashing approach first came to my mind but it passed only 86 / 98 testcases
public class OnlineElection {

    private int[] persons;
    private int[] times;

    public OnlineElection(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    public int q(int t) {

        int idx = getIndex(t);
        if (idx == -1) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= idx; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int leader = 0;

        for (int i = 0; i <= idx; i++) {
            int p = persons[i];
            int count = map.getOrDefault(p, 0) + 1;
            map.put(p, count);

            if (count >= max) {
                max = count;
                leader = p;
            }
        }

        return leader;
    }

    public int getIndex(int t) {
        int idx = -1;

        for (int i = 0; i < times.length; i++) {
            if (times[i] <= t) {
                idx = i;
            } else {
                break;
            }
        }

        return idx;
    }
}