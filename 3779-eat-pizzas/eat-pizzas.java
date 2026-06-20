class Solution {
    public long maxWeight(int[] pizzas) {

        Arrays.sort(pizzas);
        int n = pizzas.length;
        int days = n / 4;

        int odd = (days + 1) / 2;
        int even = days - odd;

        long ans = 0;
        for (int i = n - odd; i < n; i++) {
            ans += pizzas[i];
        }
        int idx = n - odd - 2;
        while (even-- > 0) {
            ans += pizzas[idx];
            idx -= 2;
        }
        return ans;
    }
}