import java.util.Arrays;

public class EatPizza {

    public long maxWeight(int[] pizzas) {

        Arrays.sort(pizzas);
        int i = 0;
        int j = pizzas.length - 1;
        long ans = 0;
        boolean flag = true;

        while(i < j) {
            if(flag) {
                i += 3;
                ans += pizzas[j];
                j--;
                flag = false;
            }else {
                i += 2;
                j--;
                ans += pizzas[j];
                j--;
                flag = true;
            }
        }
        return ans;
    }
}
