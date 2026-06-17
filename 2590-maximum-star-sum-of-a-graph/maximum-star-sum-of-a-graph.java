class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int n = vals.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum = vals[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
            for(int j=0;j<list.get(i).size();j++) pq.add(vals[list.get(i).get(j)]);
            int l=0;
            while(pq.size()>0 && l != k) {
                int x =  pq.poll();
                if(x <= 0){
                    break;
                }else{
                    sum += x;
                    l++;
                }
            }
            max = Math.max(sum , max);
        }
        return max;
    }
}