import java.util.List;
import java.util.Map;

import java.util.*;


// this works but gives time limit exceeded after passing 88 / 100 test cases.
class FoodRatings {

    private Map<String, Pair> map;
    private Map<String, String> cus;
    private Map<String, Integer> foodRating;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        map = new HashMap<>();
        cus = new HashMap<>();
        foodRating = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {

            cus.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            if (map.containsKey(cuisines[i])) {

                Pair pair = map.get(cuisines[i]);

                String preFood = pair.name;
                int preRating = pair.rating;

                int newRating = ratings[i];
                String food = foods[i];

                if (newRating > preRating ||
                        (newRating == preRating && food.compareTo(preFood) < 0)) {

                    map.put(cuisines[i], new Pair(food, newRating));
                }

            } else {
                map.put(cuisines[i], new Pair(foods[i], ratings[i]));
            }
        }
    }

    public void changeRating(String food, int newRating) {

        String cuisine = cus.get(food);

        foodRating.put(food, newRating);

        String bestFood = null;
        int bestRating = -1;

        for (String f : cus.keySet()) {

            if (cus.get(f).equals(cuisine)) {

                int rating = foodRating.get(f);

                if (bestFood == null ||
                        rating > bestRating ||
                        (rating == bestRating && f.compareTo(bestFood) < 0)) {

                    bestRating = rating;
                    bestFood = f;
                }
            }
        }

        map.put(cuisine, new Pair(bestFood, bestRating));
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).name;
    }

    static class Pair {
        String name;
        int rating;

        public Pair(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
}


// this is the final optimized approach and this got accepted as well
class FoodRatings2 {

    private Map<String, TreeSet<Pair>> cuisineMap;
    private Map<String, Pair> foodMap;

    public FoodRatings2(String[] foods, String[] cuisines, int[] ratings) {

        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {

            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>());

            Pair pair = new Pair(foods[i], cuisines[i], ratings[i]);

            cuisineMap.get(cuisines[i]).add(pair);
            foodMap.put(foods[i], pair);
        }
    }

    public void changeRating(String food, int newRating) {

        Pair old = foodMap.get(food);

        TreeSet<Pair> set = cuisineMap.get(old.cuisine);
        set.remove(old);

        Pair updated = new Pair(food, old.cuisine, newRating);

        set.add(updated);
        foodMap.put(food, updated);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }

    static class Pair implements Comparable<Pair> {
        String name;
        String cuisine;
        int rating;

        public Pair(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public int compareTo(Pair o) {
            if (this.rating != o.rating) {
                return o.rating - this.rating;
            }
            return this.name.compareTo(o.name);
        }
    }
}
