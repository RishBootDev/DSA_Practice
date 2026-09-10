import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public String[] createGrid(int m, int n, int k) {

        if (k == 1) {
            return fillOne(m, n);
        } else if (k == 2) {
            if (m == 1 || n == 1) return new String[0];
            return fillTwo(m, n);
        } else if (k == 3) {
            if (m == 1 || n == 1) return new String[0];
            if (m == 2 && n == 2) return new String[0];
            return fillThree(m, n);
        } else if (k == 4) {
            if (m == 1 || n == 1) return new String[0];
            if (m == 2 && n < 4) return new String[0];
            if (n == 2 && m < 4) return new String[0];

            return fillFour(m, n);
        }

        return new String[0];
    }

    public String[] fillOne(int m, int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }

            ans.add(sb.toString());
        }

        return ans.toArray(new String[0]);
    }

    public String[] fillTwo(int m, int n) {

        String[] ans = fillOne(m, n);

        StringBuilder sb = new StringBuilder(ans[1]);
        sb.setCharAt(n - 2, '.');
        ans[1] = sb.toString();

        return ans;
    }

    public String[] fillThree(int m, int n) {

        if (n >= 3) {

            String[] ans = fillTwo(m, n);

            StringBuilder sb = new StringBuilder(ans[1]);
            sb.setCharAt(n - 3, '.');
            ans[1] = sb.toString();

            return ans;
        }

        String[] ans = new String[m];
        Arrays.fill(ans, "#.");

        ans[0] = "..";
        ans[1] = "..";
        ans[2] = "..";

        return ans;
    }

    public String[] fillFour(int m, int n) {

        if (n >= 4) {

            String[] ans = fillThree(m, n);

            StringBuilder sb = new StringBuilder(ans[1]);
            sb.setCharAt(n - 4, '.');
            ans[1] = sb.toString();

            return ans;
        }

        if (m >= 4 && n == 2) {

            String[] ans = new String[m];
            Arrays.fill(ans, "#.");

            ans[0] = "..";
            ans[1] = "..";
            ans[2] = "..";
            ans[3] = "..";

            return ans;
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = "###";
        }

        ans[0] = "..#";
        ans[1] = "...";

        StringBuilder thirdRow = new StringBuilder("...");
        thirdRow.setCharAt(0, '#');
        ans[2] = thirdRow.toString();

        for (int j = 2; j < n; j++) {
            StringBuilder row = new StringBuilder(ans[2]);
            row.setCharAt(j, '.');
            ans[2] = row.toString();
        }

        for (int i = 3; i < m; i++) {
            StringBuilder row = new StringBuilder(ans[i]);
            row.setCharAt(n - 1, '.');
            ans[i] = row.toString();
        }

        return ans;
    }
}