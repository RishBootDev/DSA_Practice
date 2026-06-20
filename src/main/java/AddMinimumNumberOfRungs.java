public class AddMinimumNumberOfRungs {

    public int addRungs(int[] rungs, int dist) {

        int temp = 0;
        int ans = 0;

        for(int c : rungs) {
            if(temp + dist < c) {
               int start = temp + dist;
               int end = c - dist;
               ans += end - start + 1;
            }
            temp = c;
        }
        return ans;
    }
}
