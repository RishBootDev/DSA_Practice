import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {

        Collections.sort(timePoints, (a, b) -> {
            if (a.charAt(0) != b.charAt(0)) return Character.compare(a.charAt(0), b.charAt(0));
            else if (a.charAt(1) != b.charAt(1)) return Character.compare(a.charAt(1), b.charAt(1));
            else if (a.charAt(3) != b.charAt(3)) return Character.compare(a.charAt(3), b.charAt(3));
            else if (a.charAt(4) != b.charAt(4)) return Character.compare(a.charAt(4), b.charAt(4));
            return 0;
        });

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < timePoints.size() - 1; i++) {
            int a = diff(timePoints.get(i), timePoints.get(i + 1));
            min = Math.min(a, min);
        }

        int first = toMinutes(timePoints.get(0));
        int last = toMinutes(timePoints.get(timePoints.size() - 1));
        min = Math.min(min, 1440 - last + first);

        return min;
    }

    public int diff(String s1, String s2) {
        int min = toMinutes(s1);
        int smin = toMinutes(s2);
        return smin - min;
    }

    public int toMinutes(String s) {
        int min = Integer.parseInt(s.substring(0, 2)) * 60;
        min += Integer.parseInt(s.substring(3));
        return min;
    }

}
