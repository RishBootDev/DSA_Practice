import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
}
