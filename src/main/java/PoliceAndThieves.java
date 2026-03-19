import java.util.ArrayList;
import java.util.List;

public class PoliceAndThieves {

    // this is the bruteforce solution of the problem
    public int catchThieves(char[] arr, int k) {

        boolean caught[] = new boolean[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 'P') {

                int start = Math.max(0, i - k);
                int end = Math.min(arr.length - 1, i + k);
                for (int j = start; j <= end; j++) {

                    if (arr[j] == 'T' && !caught[j]) {
                        caught[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }


    // This is the optimized version of the catch thieves problem
    public int catchThieves2(char[] arr, int k) {

        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        int i = 0, j = 0, count = 0;

        while (i < police.size() && j < thieves.size()) {

            int p = police.get(i);
            int t = thieves.get(j);

            if (Math.abs(p - t) <= k) {
                count++;
                i++;
                j++;
            } else if (t < p) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
