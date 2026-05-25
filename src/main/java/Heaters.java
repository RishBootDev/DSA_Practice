import java.util.*;


// this is leetcode 475
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        Arrays.sort(houses);
        int max = 0;
        int j = 0;

        for (int i = 0; i < heaters.length - 1; i++) {

            int start = heaters[i];
            int end = heaters[i + 1];
            while (j < houses.length && houses[j] <= end) {
                if (houses[j] >= start) {

                    int rad1 = houses[j] - start;
                    int rad2 = end - houses[j];
                    max = Math.max(max, Math.min(rad1, rad2));
                }
                j++;
            }
        }

        if (houses[0] < heaters[0]) {
            max = Math.max(max, heaters[0] - houses[0]);
        }

        if (houses[houses.length - 1] > heaters[heaters.length - 1]) {
            max = Math.max(
                    max,
                    houses[houses.length - 1] - heaters[heaters.length - 1]
            );
        }

        return max;

    }
}
