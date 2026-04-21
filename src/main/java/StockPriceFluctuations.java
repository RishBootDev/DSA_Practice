import java.util.HashMap;
import java.util.Map;

public class StockPriceFluctuations {

    private Map<Integer, Integer> map;
    private int max;
    private int min;
    private int curr;

    public StockPriceFluctuations() {
        this.map = new HashMap<>();
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
        this.curr = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        max = Math.max(price, max);
        min = Math.max(price, min);
        curr = Math.max(curr, timestamp);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(curr);
    }

    public int maximum() {
        return map.get(max);
    }

    public int minimum() {
        return map.get(min);
    }
}
