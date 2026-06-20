public class KnightDialer {

    public int knightDialer(int n) {

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ans += helper(n - 1, i, j);
            }
        }
        return ans;
    }
    public int helper(int n, int i , int j) {

        if(n == 0) return 1;

        int count = 0;
        // move up
        if(check(i - 2, j - 1)) count += helper(n - 1, i - 2, j - 1);
        if(check(i - 2, j + 1)) count += helper(n - 1, i - 2, j + 1);

        // move down
        if(check(i + 2, j - 1)) count += helper(n - 1, i + 2, j - 1);
        if(check(i + 2, j + 1)) count += helper(n - 1, i + 2, j + 1);

        // move left
        if(check(i - 1, j - 2)) count += helper(n - 1, i - 1, j - 2);
        if(check(i - 1, j + 2)) count += helper(n - 1, i - 1, j + 2);

        // move right
        if(check(i + 1, j - 2)) count += helper(n - 1, i + 1, j - 2);
        if(check(i + 1, j + 2)) count += helper(n - 1, i +1, j + 2);

        return count;
    }

    public boolean check(int i, int j) {
        if(i < 0 || j < 0) return false;
        if(i >= 4 || j >= 3) return false;

        if(i == 3 && (j == 0 || j == 2)) return false;
        return true;
    }
}
