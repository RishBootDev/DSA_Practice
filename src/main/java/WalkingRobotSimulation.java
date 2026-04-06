import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {

        int x = 0, y = 0;
        int maxDist = 0;

        Set<String> set = new HashSet<>();
        for (int[] arr : obstacles) {
            String temp = arr[0] + " " + arr[1];
            set.add(temp);
        }

        int dir = 0;

        for (int cmd : commands) {

            if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {

                int k = cmd;

                if (dir == 0) {
                    while (k-- > 0) {
                        String point = x + " " + (y + 1);
                        if (set.contains(point)) break;
                        y += 1;
                    }

                } else if (dir == 1) {
                    while (k-- > 0) {
                        String point = (x + 1) + " " + y;
                        if (set.contains(point)) break;
                        x += 1;
                    }

                } else if (dir == 2) {
                    while (k-- > 0) {
                        String point = x + " " + (y - 1);
                        if (set.contains(point)) break;
                        y -= 1;
                    }

                } else {
                    while (k-- > 0) {
                        String point = (x - 1) + " " + y;
                        if (set.contains(point)) break;
                        x -= 1;
                    }
                }
            }

            maxDist = Math.max(maxDist, x * x + y * y);
            System.out.println(x + " " + y);
        }

        return maxDist;
    }

}
