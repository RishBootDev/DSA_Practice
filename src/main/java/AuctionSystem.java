import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class AuctionSystem {
    Map<String, Integer> amt;
    Map<Integer, PriorityQueue<Integer>> map;

    public AuctionSystem() {
        amt = new HashMap<>();
        map = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        PriorityQueue<Integer> pq = map.computeIfAbsent(itemId, k -> new PriorityQueue<>((p1, p2) -> {
            int amt1 = amt.get(p1 + " " + k);
            int amt2 = amt.get(p2 + " " + k);

            if (amt1 == amt2) return p1 - p2;
            return amt2 - amt1;
        }));

        String key = userId + " " + itemId;

        if (amt.containsKey(key)) {
            pq.remove(userId);
        }

        amt.put(key, bidAmount);
        pq.add(userId);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        PriorityQueue<Integer> pq = map.get(itemId);

        if (pq != null) {
            pq.remove(userId);
            amt.put(userId + " " + itemId, newAmount);
            pq.add(userId);
        }
    }

    public void removeBid(int userId, int itemId) {
        PriorityQueue<Integer> pq = map.get(itemId);

        if (pq != null) {
            pq.remove(userId);
            amt.remove(userId + " " + itemId);
        }
    }

    public int getHighestBidder(int itemId) {
        PriorityQueue<Integer> pq = map.get(itemId);

        if (pq == null || pq.isEmpty()) return -1;

        return pq.peek();
    }
}