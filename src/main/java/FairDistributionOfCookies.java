public class FairDistributionOfCookies {

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {

        int[] children = new int[k];
        helper(cookies, 0, children);
        return ans;
    }

    public void helper(int[] cookies,
                       int i,
                       int[] children) {

        if (i == cookies.length) {

            int max = 0;
            for (int x : children) {
                max = Math.max(max, x);
            }
            ans = Math.min(ans, max);
            return;
        }

        for (int j = 0; j < children.length; j++) {

            children[j] += cookies[i];
            helper(cookies, i + 1, children);
            children[j] -= cookies[i];
        }
    }
}