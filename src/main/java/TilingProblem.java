public class TilingProblem {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(tilingProblem(n));

        int a = 4;
        int b = 7;
        int ans = 0;
        for (int i = 0; i < b; i++) {
            ans += a;
        }
        System.out.println(ans);
    }

    static int tilingProblem(int n) {
        int first = 1;
        int second = 1;

        if (n <= 1) return 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }

        return second;
    }
}
