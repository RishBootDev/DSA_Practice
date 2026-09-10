import java.util.Arrays;

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        return people;
    }
}
