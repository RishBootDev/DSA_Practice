import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindUAM {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int min = logs[i][1];

            map.computeIfAbsent(id, x -> new HashSet<>()).add(min);
        }

        int[] result = new int[k];

        for (HashSet<Integer> set : map.values()) {
            int uam = set.size();

            if (uam <= k) {
                result[uam - 1]++;
            }
        }

        return result;
    }
}
