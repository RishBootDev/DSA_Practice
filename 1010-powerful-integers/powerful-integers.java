class Solution {

    private Set<String> dp = new HashSet<>();

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> set = new HashSet<>();
        helper(x, y, 0, 0, bound, set);
        return new ArrayList<>(set);
    }

    public void helper(int x, int y, int i, int j,
                       int bound, Set<Integer> set) {

        String key = i + "#" + j;

        if (dp.contains(key)) {
            return;
        }
        dp.add(key);
        int ans = (int)(Math.pow(x, i) + Math.pow(y, j));

        if (ans > bound) {
            return;
        }
        set.add(ans);
        if (x != 1) {
            helper(x, y, i + 1, j, bound, set);
        }
        if (y != 1) {
            helper(x, y, i, j + 1, bound, set);
        }
    }
}