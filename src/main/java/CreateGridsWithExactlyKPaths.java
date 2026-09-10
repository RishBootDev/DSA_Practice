import java.util.ArrayList;
import java.util.List;

public class CreateGridsWithExactlyKPaths {

    public String[] createGrid(int m, int n, int k) {

        if (k == 1) {
            return fillOne(m, n);
        } else if (k == 2) {
            if (m == 1 || n == 1) return new String[0];
            return fillTwo(m, n);
        } else if (k == 3) {
            if (m == 1 || n == 1) return new String[0];
            else if (m == 2 && n == 2) return new String[0];
            return fillThree(m, n);
        } else {
            if (m == 1 || n == 1) return new String[0];
            if (m == 2 && n <= 3) return new String[0];
            return fillFour(m, n);
        }
    }

    public String[] fillOne(int m, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if(i == 0 ||j == n - 1) sb.append(".");
                else sb.append("#");
            }
            ans.add(sb.toString());
        }
        return ans.toArray(new String[0]);
    }
    public String [] fillTwo(int m, int n) {
        String ans[] = fillOne(m, n);
        StringBuilder sb = new StringBuilder(ans[1]);
        sb.setCharAt(sb.length()-2, '.');
        ans[1] = sb.toString();
        return ans;
    }
    public String [] fillThree(int m, int n) {
        String ans[] = fillTwo(m, n);
        if(m > 2) {
            StringBuilder sb = new StringBuilder(ans[1]);
            sb.setCharAt(sb.length()-3, '.');
            ans[1] = sb.toString();
        }else {
            StringBuilder sb = new StringBuilder(ans[2]);
            sb.setCharAt(sb.length()-2, '.');
            ans[2] = sb.toString();
        }
        return ans;
    }
    public String[] fillFour(int m, int n) {
        String[] ans = fillThree(m, n);

        if (m > 2) {
            StringBuilder sb = new StringBuilder(ans[1]);
            sb.setCharAt(sb.length() - 4, '.');
            ans[1] = sb.toString();
        } else {
            StringBuilder sb = new StringBuilder(ans[2]);
            sb.setCharAt(sb.length() - 3, '.');
            ans[2] = sb.toString();
        }

        return ans;
    }
}
