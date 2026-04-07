import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {

        Collections.sort(tasks);
        Collections.sort(processorTime);
        int j = 0;
        int max = Integer.MIN_VALUE;
        int time = Integer.MIN_VALUE;

        for (int i = tasks.size() - 1; i >= 0 ; i--) {

            if(i%4 == 1) {
                j++;
                time = Math.max(time, max);
                max = Integer.MIN_VALUE;
            }else {
                max = Math.max(max , processorTime.get(j) * tasks.get(i));
            }
        }

        return time;

    }
}
