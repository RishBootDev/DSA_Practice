import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class TablePartitioning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            boolean[][] know = new boolean[n + 1][n + 1];

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                know[x][y] = true;
                know[y][x] = true;
            }

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (!know[i][j]) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            int[] table = new int[n + 1];
            boolean possible = true;

            for (int i = 1; i <= n; i++) {
                if (table[i] == 0) {
                    if (!bfs(i, graph, table)) {
                        possible = false;
                        break;
                    }
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }

    public static boolean bfs(int start, List<List<Integer>> graph, int[] table) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        table[start] = 1;

        while (!queue.isEmpty()) {
            int currentFriend = queue.poll();

            for (int friend : graph.get(currentFriend)) {
                if (table[friend] == 0) {
                    table[friend] = -table[currentFriend];
                    queue.add(friend);
                } else if (table[friend] == table[currentFriend]) {
                    return false;
                }
            }
        }
        return true;
    }
}
