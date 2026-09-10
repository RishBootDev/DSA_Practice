import java.util.*;


// this is a valid solution
public class ExamTracker {

    Map<Integer, Integer> map;
    List<Integer> list = new ArrayList<>();

    public ExamTracker() {
        this.map = new LinkedHashMap<>();
    }

    public void record(int time, int score) {
        map.put(time, score);
        list.add(time);
    }

    public long totalScore(int startTime, int endTime) {
        int start = first(startTime);
        int end = last(endTime);

        if (start == list.size() || end == -1 || start > end) {
            return 0;
        }

        long ans = 0;

        for (int i = start; i <= end; i++) {
            ans += map.get(list.get(i));
        }

        return ans;
    }

    public int first(int start) {
        int l = 0;
        int r = list.size() - 1;
        int ans = list.size();

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= start) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int last(int end) {
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= end) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}