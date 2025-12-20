import java.util.Arrays;

public class FlatLandSearching {


    static int flatlandSpaceStations(int n, int[] c) {

        Arrays.sort(c);

        int maxDist = 0;

        maxDist = Math.max(maxDist, c[0]);

        maxDist = Math.max(maxDist, (n - 1) - c[c.length - 1]);

        for (int i = 0; i < c.length - 1; i++) {
            int gap = (c[i + 1] - c[i]) / 2;
            maxDist = Math.max(maxDist, gap);
        }

        return maxDist;
    }

}
