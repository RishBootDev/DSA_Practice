import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighAccessEmployee {

    private int convertToMinutes(String timeStr) {
        int hour = Integer.parseInt(timeStr.substring(0, 2));
        int minute = Integer.parseInt(timeStr.substring(2, 4));
        return hour * 60 + minute;
    }

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        access_times.sort((a, b) -> {
            int cmp = a.get(0).compareTo(b.get(0));
            if (cmp == 0) {
                return a.get(1).compareTo(b.get(1));
            }
            return cmp;
        });

        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < access_times.size()) {
            String name = access_times.get(i).get(0);
            List<Integer> times = new ArrayList<>();
            int j = i;

            while (j < access_times.size() && access_times.get(j).get(0).equals(name)) {
                times.add(convertToMinutes(access_times.get(j).get(1)));
                j++;
            }

            boolean found = false;
            for (int start = 0, end = 0; end < times.size(); end++) {
                while (times.get(end) - times.get(start) >= 60) {
                    start++;
                }
                if (end - start + 1 >= 3) {
                    found = true;
                    break;
                }
            }
            if (found) {
                result.add(name);
            }
            i = j;
        }

        return result;
    }

}
