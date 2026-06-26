import java.util.*;

public class ExamTracker {

    List<Integer> timeList;
    List<Long> prefixSum;

    public ExamTracker() {
        this.timeList = new ArrayList<>();
        this.prefixSum = new ArrayList<>();
    }

    public void record(int time, int score) {
        timeList.add(time);

        if (prefixSum.isEmpty()) {
            prefixSum.add((long) score);
        } else {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + score);
        }
    }

    public long totalScore(int startTime, int endTime) {
        int start = first(startTime);
        int end = last(endTime);

        if (start == timeList.size() || end == -1 || start > end) {
            return 0;
        }

        long beforeStart = start == 0 ? 0 : prefixSum.get(start - 1);
        return prefixSum.get(end) - beforeStart;
    }

    public int first(int start) {
        int l = 0;
        int r = timeList.size() - 1;
        int ans = timeList.size();
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (timeList.get(mid) >= start) {
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
        int r = timeList.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (timeList.get(mid) <= end) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}