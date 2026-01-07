import java.util.*;

public class UpWardPath {
    static int N;
    static int[] a1, a2;
    static Boolean[][] memo;

    static boolean dfs(int col, int row, int val) {
        if (col == N - 1 && row == 1)
            return true;

        if (memo[col][row] != null)
            return memo[col][row];

        boolean res = false;

        // Move RIGHT
        if (col + 1 < N) {
            int topNext = a1[col + 1];
            int bottomNext = a2[col + 1];

            if (topNext >= val)
                res |= dfs(col + 1, row, topNext);
            if (bottomNext >= val)
                res |= dfs(col + 1, row, bottomNext);
        }

        // Move DOWN (only from top row)
        if (!res && row == 0) {
            int downVal = a2[col];
            if (downVal >= val)
                res |= dfs(col, 1, downVal);
        }

        return memo[col][row] = res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            a1 = new int[N];
            a2 = new int[N];

            for (int i = 0; i < N; i++) a1[i] = sc.nextInt();
            for (int i = 0; i < N; i++) a2[i] = sc.nextInt();

            memo = new Boolean[N][2];

            boolean possible =
                    dfs(0, 0, a1[0]) ||
                            dfs(0, 0, a2[0]);

            System.out.println(possible ? "Yes" : "No");
        }
    }
}

