import java.util.List;
import java.util.Map;

import java.util.*;

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
