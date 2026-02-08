import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArray {

    public int[] findThePrefixCommonArray(int[] arr, int[] barr) {

        Set<Integer> set = new HashSet<>();
        int ans [] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            set.add(arr[i]);
            int count = 0;

            for (int j = 0; j <= i; j++) {
                if(set.contains(arr[j])) count++;
            }

            ans [i] = count;

        }

        return ans;

    }
}
