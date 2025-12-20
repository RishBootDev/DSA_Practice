import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallContainers {
    public static String organizingContainers(List<List<Integer>> container) {

        int n = container.size();
        long[] containerCapacity = new long[n];
        long[] ballTypeCount = new long[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerCapacity[i] += container.get(i).get(j); // row sum
                ballTypeCount[j] += container.get(i).get(j);      // column sum
            }
        }

        Arrays.sort(containerCapacity);
        Arrays.sort(ballTypeCount);

        for (int i = 0; i < n; i++) {
            if (containerCapacity[i] != ballTypeCount[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }


    static class Container{
        int id;
        List<Integer> balls;

        public Container(int id,List<Integer> list){
            this.id=id;
            this.balls=list;
        }
    }
}
