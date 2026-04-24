import java.util.*;

public class CroakCroak {

    public int minNumberOfFrogs(String croakOfFrogs) {

        char [] arr = croakOfFrogs.toCharArray();
        Arrays.sort(arr);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        if(set.size() > 1) return -1;
        return map.get('a');

    }
}
