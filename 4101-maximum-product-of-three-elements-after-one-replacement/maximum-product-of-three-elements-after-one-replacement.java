class Solution {

    public long maxProduct(int[] nums) {

        List<Long> list = new ArrayList<>();

        for (int c : nums) {
            list.add((long) c);
        }
        Collections.sort(list,
                (a, b) -> Long.compare(Math.abs(b), Math.abs(a)));

        long prod = list.get(0) * list.get(1);

        if (prod < 0) {
            return prod * -100000L;
        }
        return prod * 100000L;
    }
}