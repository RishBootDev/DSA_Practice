import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfWaysToMoveBall {


    public static void main(String[] args) {

    }

    public int[] minOperations(String boxes) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i)=='1') list.add(i);
        }

        int ans[] = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            int temp = 0;
            for (int j = 0; j < list.size(); j++) {
                temp+=Math.abs(i-j);
            }
            ans[i] = temp;
        }
        return ans;
    }
}
