class Solution {
    public long maxAlternatingSum(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (p1, p2) -> Math.abs(p2) - Math.abs(p1)
        );
        
        for(int c : nums) pq.add(Math.abs(c));

        int n = nums.length % 2 == 0? nums.length/2 : nums.length/2 + 1;
        long ans = 0;
        while(n -- > 0 && !pq.isEmpty()) {
            ans += Math.pow(pq.poll(), 2);
        }
        
        while(!pq.isEmpty()) ans -= Math.pow(pq.poll(), 2);
        
        return ans;

    }
}