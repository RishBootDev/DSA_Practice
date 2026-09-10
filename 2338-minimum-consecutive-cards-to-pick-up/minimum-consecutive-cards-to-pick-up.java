class Solution {
    
    public int minimumCardPickup(int[] cards) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                List<Integer> temp = map.get(cards[i]);
                temp.add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(cards[i], temp);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {
            List<Integer> temp = ent.getValue();

            if (temp.size() > 1) {
                for (int i = 1; i < temp.size(); i++) {
                    ans = Math.min(temp.get(i) - temp.get(i - 1) + 1, ans);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}