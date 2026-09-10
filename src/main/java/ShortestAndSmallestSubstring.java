import java.util.ArrayList;
import java.util.List;

public class ShortestAndSmallestSubstring {

    public String shortestBeautifulSubstring(String s, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                list.add(i);
        }
        if (k > list.size())
            return "";

        int min = Integer.MAX_VALUE;
        int idx[] = new int[2];

        for (int i = 0; i + k - 1 < list.size(); i++) {

            int count = list.get(i + k - 1) - list.get(i);
            if (count < min) {
                min = count;
                idx[0] = list.get(i);
                idx[1] = list.get(i + k - 1);
            }
        }

        return s.substring(idx[0], idx[1] + 1);
    }

}
