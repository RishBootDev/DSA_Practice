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

    public int[] findThePrefixCommonArrayOptimized(int[] arr, int[] barr) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int ans [] = new int[arr.length];

        set1.add(arr[0]);
        set2.add(barr[0]);
        if(set2.contains(arr[0])) ans[0]++;
        if(set1.contains(barr[0])) ans[0]++;


        for (int i = 1; i < arr.length; i++) {

            set1.add(arr[i]);
            set2.add(barr[i]);

            int count =0;
            if(set2.contains(arr[i])) count++;

            if(set1.contains(barr[i])) count++;

            ans [i] = count+ans[i-1];
        }
        return ans;
    }
}
