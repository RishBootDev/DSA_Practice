import java.util.*;

public class DividePlayers {

    public long dividePlayers(int[] skill) {

        Arrays.sort(skill);

        int i = 0, j = skill.length-1;
        Set<Integer> set = new HashSet<>();
        long ans = 0;

        while(i < j) {
            set.add(skill[i] + skill[j]);
            ans += ((long) skill[i] * skill[j]);
            i++;
            j--;
        }

        if(set.size() != 1) return -1;

        return ans;
    }


    // this is the more optimized version of the above code in terms of time but takes extra space of hashmap
        public long dividePlayers2(int[] skill) {
            int n = skill.length;
            int teams = n / 2;

            long totalSum = 0;
            for (int s : skill) {
                totalSum += s;
            }

            if (totalSum % teams != 0) return -1;

            int target = (int)(totalSum / teams);
            Map<Integer, Integer> freq = new HashMap<>();

            for (int s : skill) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }

            long ans = 0;

            for (int s : skill) {
                if (freq.get(s) == 0) continue;

                int needed = target - s;

                if (!freq.containsKey(needed) || freq.get(needed) == 0) {
                    return -1;
                }

                if (s == needed && freq.get(s) < 2) {
                    return -1;
                }

                freq.put(s, freq.get(s) - 1);
                freq.put(needed, freq.get(needed) - 1);

                ans += (long) s * needed;
            }

            return ans;
        }

}
