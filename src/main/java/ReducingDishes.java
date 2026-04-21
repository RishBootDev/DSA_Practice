import java.util.Arrays;

public class ReducingDishes {


    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int suf= 0;
        int result = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            suf += satisfaction[i];

            if (suf < 0) break;

            result += suf;
        }

        return result;
    }
}
