import java.util.ArrayList;
import java.util.List;

public class BuyMaximumStocks {

    public static void main(String[] args) {
        int[] prices ={11,13,9,4};
        System.out.println(buyMaximumProducts(4,46,prices)); // 7
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {

        int sum=0;
        int count=0;

        List<Pair> pairs=new ArrayList<>();

        for(int i=0;i<price.length;i++){
            Pair pair=new Pair(price[i],i+1);
            pairs.add(pair);
        }

        pairs.sort((a, b) -> a.price - b.price);

        for (Pair pair : pairs) {

            if (sum + pair.price * pair.quantity <= k) {
                sum += pair.price * pair.quantity;
                count += pair.quantity;
            } else {

                int taken = 0;
                while (sum + pair.price <= k && taken < pair.quantity) {
                    sum += pair.price;
                    count++;
                    taken++;
                }
                break;
            }
        }

        return count;
    }

    static class Pair{
        int price;
        int quantity;

        public Pair(int price,int quantity){
            this.price=price;
            this.quantity=quantity;
        }
    }
}
