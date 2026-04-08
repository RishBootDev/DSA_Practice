import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            String comp = complement(sb.toString());

            if(map.containsKey(sb.toString())) {
                map.put(sb.toString(),
                        map.getOrDefault(sb.toString(), 0) + 1);
            }else if (map.containsKey(comp)) {
                map.put(sb.toString(),
                        map.getOrDefault(sb.toString(), 0) + 1);
            }else map.put(sb.toString(), 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        int max = 0;
        for(int c : list)
            max = Math.max(c, max);

        return max;
    }

    public String complement(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) =='0') sb.append(1);
            else sb.append(0);
        }

        return sb.toString();
    }
}
