import java.util.HashSet;

public class FrogJumps {

    public int unvisitedLeaves(int N, int leaves, int frogs[]) {

        boolean[] visited = new boolean[leaves + 1];

        HashSet<Integer> set = new HashSet<>();

        for (int f : frogs) {
            if (f == 1) return 0;
            if (f <= leaves) set.add(f);
        }


        for (int f : set) {
            for (int i = f; i <= leaves; i += f) {
                visited[i] = true;
            }
        }

        int count = 0;
        for (int i = 1; i <= leaves; i++) {
            if (!visited[i]) count++;
        }

        return count;
    }
}
