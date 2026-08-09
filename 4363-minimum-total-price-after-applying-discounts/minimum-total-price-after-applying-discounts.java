class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mq = new PriorityQueue<>(Collections.reverseOrder());

        for(int c : prices) pq.add(c);

        for(int c : discounts) mq.add(c);

        double ans = 0;

        while(!pq.isEmpty() && !mq.isEmpty()) {
            double price = pq.poll();
            double discount = mq.poll();

            ans += price * (100 - discount)/100.0;
        }

        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}