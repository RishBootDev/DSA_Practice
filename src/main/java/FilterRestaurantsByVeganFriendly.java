import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterRestaurantsByVeganFriendly {

    public List<Integer> filterRestaurants(int[][] restaurants,
                                           int veganFriendly,
                                           int maxPrice,
                                           int maxDistance) {

        List<Restaurent> list = new ArrayList<>();

        for(int [] restaurent : restaurants) {
            int id = restaurent[0];
            int rating = restaurent[1];
            boolean vegan = restaurent[2] == 1;
            int price = restaurent[3];
            int distance = restaurent[4];

            Restaurent res = new Restaurent(id, rating, vegan, price, distance);

            if(veganFriendly == 1 && vegan && price <= maxPrice && distance <= maxDistance) list.add(res);

            else if (veganFriendly == 0 && price <= maxPrice && distance <= maxDistance)list.add(res);
        }

        Collections.sort(list, (r1, r2)-> {
            if(r1.rating == r2.rating) return r2.id - r1.id;
            return r2.rating - r1.rating;
        });
        List<Integer> ans = new ArrayList<>();

        for(Restaurent res : list) ans.add(res.id);

        return ans;

    }
    static class Restaurent{
        int id;
        int rating;
        boolean vegan;
        int price;
        int distance;

        public Restaurent(int id, int rating, boolean vegan, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.vegan = vegan;
            this.price = price;
            this.distance = distance;
        }
    }
}
