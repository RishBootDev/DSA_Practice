import java.util.*;

public class CountGoodMeals {

    private int MOD = 10000000;

    // this is the correct solution but got me Time limit exceeded
    public int countPairs(int[] del) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 21; i++) {
            set.add((int)Math.pow(2, i));
        }

        int count = 0;

        for (int i = 0; i < del.length; i++) {
            for (int j = i + 1; j < del.length; j++) {
                int sum = del[i] + del[j];

                if(set.contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }

    // slight observation to the problem and it is solved
    public int countPairs2(int[] del) {

        Map<Integer, Integer> map = new HashMap<>();

        long count = 0;
        for (int j = 0; j < del.length; j++) {
            for (int i = 0; i <= 21; i++) {
                int pow = 1 << i;
                int diff = pow - del[j];
                count += map.getOrDefault(diff, 0);
            }
            map.put(del[j], map.getOrDefault(del[j], 0) + 1);
        }
        return (int)(count % MOD);
    }
}
