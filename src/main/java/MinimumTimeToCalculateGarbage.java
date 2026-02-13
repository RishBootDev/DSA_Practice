import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCalculateGarbage {

    public int garbageCollection(String[] garbage, int[] travel) {

        List<Integer> listG = new ArrayList<>();
        List<Integer> listM = new ArrayList<>();
        List<Integer> listP = new ArrayList<>();

        for (int i = 0; i < garbage.length; i++) {

            int countM = 0;
            int countG = 0;
            int countP = 0;

            String temp = garbage[i];

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'M') countM++;
                else if (temp.charAt(j) == 'P') countP++;
                else countG++;
            }

            listG.add(countG);
            listM.add(countM);
            listP.add(countP);
        }

        int ans = 0;

        ans += calculate(listG, travel);
        ans += calculate(listM, travel);
        ans += calculate(listP, travel);

        return ans;
    }

    private int calculate(List<Integer> list, int[] travel) {

        int first = getFirstIndex(list);
        int last = getLastIndex(list);

        if (first == -1) return 0;

        int sum = 0;

        for (int i = first; i <= last; i++) {
            sum += list.get(i);
        }

        for (int i = first; i < last; i++) {
            sum += travel[i];
        }

        return sum;
    }

    public int getFirstIndex(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) return i;
        }
        return -1;
    }

    public int getLastIndex(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != 0) return i;
        }
        return -1;
    }
}