import java.util.HashMap;
import java.util.Map;

public class TaskScheduler2 {

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Integer> map = new HashMap<>();

        int day = 0;
        for (int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])) {
                int val = map.get(tasks[i]);
                if(day - val < space) {
                    day += val + space;
                    map.put(tasks[i], day);
                }else {
                    map.put(day, i);
                    day++;
                }
            }else {
                map.put(tasks[i], i);
                day++;
            }
        }
        return day;
    }
}
