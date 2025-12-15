import java.util.*;

public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = tasks.length;
        int[] result = new int[n];

        PriorityQueue<Pair> available = new PriorityQueue<>(
                (a, b) -> a.server != b.server ? a.server - b.server : a.index - b.index
        );

        PriorityQueue<Pair> busy = new PriorityQueue<>(
                (a, b) -> Math.toIntExact(a.finishTime != b.finishTime ? a.finishTime - b.finishTime
                        : (a.server != b.server ? a.server - b.server : a.index - b.index))
        );

        for (int i = 0; i < servers.length; i++) {
            available.add(new Pair(servers[i], i));
        }

        long time = 0;

        for (int i = 0; i < n; i++) {

            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek().finishTime <= time) {
                available.add(busy.poll());
            }

            if (available.isEmpty()) {
                time = busy.peek().finishTime;
                while (!busy.isEmpty() && busy.peek().finishTime <= time) {
                    available.add(busy.poll());
                }
            }

            Pair server = available.poll();
            result[i] = server.index;

            server.finishTime = time + tasks[i];
            busy.add(server);
        }

        return result;
    }

    static class Pair {
        int server;
        int index;
        long finishTime;

        Pair(int server, int index) {
            this.server = server;
            this.index = index;
        }
    }
}
