import java.util.HashSet;
import java.util.Set;

public class CalculateScoreAfterPerformingInstructions {

        public long calculateScore(String[] instructions, int[] values) {

            long ans = 0;
            Set<Integer> visited = new HashSet<>();
            int i = 0;

            while (i >= 0 && i < instructions.length && !visited.contains(i)) {

                visited.add(i);

                if (instructions[i].equals("add")) {
                    ans += values[i];
                    i++;
                } else {
                    i += values[i];
                }
            }

            return ans;
        }
}

