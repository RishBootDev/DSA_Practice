import java.util.HashMap;
import java.util.Map;

class Cashier {

    private int count;
    private int n;
    private int discount;
    private Map<Integer, Integer> map;

    public Cashier(int n, int discount, int[] products, int[] prices) {

        this.n = n;
        this.discount = discount;
        map = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {

        count++;
        double sum = 0;

        for (int i = 0; i < product.length; i++) {
            int price = map.get(product[i]);
            sum += price * amount[i];
        }
        if (count % n == 0) {
            sum = sum - (sum * discount / 100.0);
        }
        return sum;
    }
}