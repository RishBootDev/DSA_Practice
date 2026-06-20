import java.util.Arrays;

public class FlipLights {

    public int flipLights(int n, int presses) {

        boolean ls[] = new boolean[n];
        return helper(n, ls, presses);
    }
    public int helper(int n, boolean []ls, int p) {
        if(p == 0) return 1;
        int ans = 0;

        // button 1
        boolean[] back = ls.clone();
        for (int i = 0; i < ls.length; i++) {
            ls[i] = !ls[i];
        }
        ans += helper(n, ls, p - 1);
        ls = back;

        // button 2
        back = ls.clone();
        for (int i = 1; i < ls.length; i+=2) {
            ls[i] = !ls[i];
        }
        ans += helper(n, ls, p - 1);
        ls = back;

        // button 3
        back = ls.clone();
        for (int i = 0; i < ls.length; i+=2) {
            ls[i] = !ls[i];
        }
        ans += helper(n, ls, p - 1);
        ls = back;

        // button 4
        back = ls.clone();
        for (int i = 0; i < ls.length; i+= 3) {
            ls[i] = !ls[i];
        }
        ans += helper(n, ls, p - 1);
        ls = back;

        return ans;
    }
}
