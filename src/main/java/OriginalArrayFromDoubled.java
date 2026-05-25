import java.util.*;

public class OriginalArrayFromDoubled {


    // to be continued
    public int[] findOriginalArray(int[] changed) {

        Arrays.sort(changed);
        Set<Integer> set = new HashSet<>();
        for(int c : changed) set.add(c);

        List<Integer> list = new ArrayList<>();
        for (int i = changed.length - 1; i >= 0 ; i--) {
            int num = changed[i];
            if(num % 2 == 0) {
                if(set.contains(num/2)) list.add(num/2);
            }else if(set.contains(num * 2)) list.add(num);
            else return new int[0];
        }
        int ans [] = new int[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans [i] = list.get(i);
        }

        return ans;

    }
}
