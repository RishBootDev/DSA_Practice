class Solution {
    
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            pq.add(str.charAt(i) - '0');
        }
        return pq.poll()*pq.poll();
    }
}