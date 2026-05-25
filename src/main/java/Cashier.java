import java.util.HashMap;
import java.util.Map;

public class Cashier {

    private int count = 0;
    private int n;
    private int discount;
    private Map<Integer, Integer> map;

    public Cashier(int n, int discount, int[] products, int[] prices) {
         this.n = n;
         this.map = new HashMap<>();
         this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        this.count++;
        int sum = 0;
        for (int i = 0; i < product.length; i++) {
            sum += product[i] * amount[i];
        }
        if(count % n == 0) return sum - discount;
        return sum;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
    }
}
