public class MinOperationsToMakeXAndYEqual {

    public int minimumOperationsToMakeEqual(int x, int y) {
        return helper(x, y);
    }
    public int helper(int x, int y) {
        if(x == y) return 0;

        int op = Integer.MAX_VALUE;
        if(x % 11 == 0) {
            op = Math.min(helper(x/11, y), op);
        }
        if(x % 5 == 0) {
            op = Math.min(helper(x/5, y), op);
        }
        op = Math.min(helper(x - 1, y), op);
        op = Math.min(helper(x + 1, y), op);
        return op;
    }
}
