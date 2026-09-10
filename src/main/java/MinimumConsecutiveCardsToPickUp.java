import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {

    public int minimumCardPickup(int[] cards) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i])) {
                List<Integer> temp = map.get(cards[i]);
                if(temp.size() == 2) {
                    temp.removeLast();
                    temp.add(i);
                }else {
                    temp.add(i);
                }
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(cards[i], temp);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {
            List<Integer> temp = ent.getValue();
            ans = Math.min(temp.getLast() - temp.getFirst(), ans);
        }
        return ans;
    }
}
