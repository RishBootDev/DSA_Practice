import java.util.PriorityQueue;

public class NumberOfOrdersInBacklog {

    public int getNumberOfBacklogOrders(int[][] orders) {

        PriorityQueue<Order> sell = new PriorityQueue<>((a, b) -> a.price - b.price);
        PriorityQueue<Order> buy = new PriorityQueue<>((a, b) -> b.price - a.price);

        int mod = 1_000_000_007;

        for (int[] order : orders) {

            int price = order[0];
            int amount = order[1];
            int type = order[2];

            if (type == 0) {

                while (amount > 0 && !sell.isEmpty() && sell.peek().price <= price) {
                    Order s = sell.poll();

                    int min = Math.min(amount, s.amount);
                    amount -= min;
                    s.amount -= min;

                    if (s.amount > 0) sell.add(s);
                }
                if (amount > 0) {
                    buy.add(new Order(price, amount, type));
                }

            } else {

                while (amount > 0 && !buy.isEmpty() && buy.peek().price >= price) {
                    Order b = buy.poll();

                    int min = Math.min(amount, b.amount);
                    amount -= min;
                    b.amount -= min;

                    if (b.amount > 0) buy.add(b);
                }
                if (amount > 0) {
                    sell.add(new Order(price, amount, type));
                }
            }
        }

        long total = 0;
        for (Order o : buy) total = (total + o.amount) % mod;
        for (Order o : sell) total = (total + o.amount) % mod;
        return (int) total;
    }

    static class Order {
        int price;
        int amount;
        int orderType;

        public Order(int price, int amount, int orderType) {
            this.price = price;
            this.amount = amount;
            this.orderType = orderType;
        }
    }
}