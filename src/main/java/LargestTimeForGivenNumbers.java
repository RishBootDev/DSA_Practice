import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenNumbers {

    public String largestTimeFromDigits(int[] arr) {

        int first = Integer.MIN_VALUE;
        int f = -1;
        int second = Integer.MIN_VALUE;
        int sec = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 2) {
                if (arr[i] > first) {
                    first = arr[i];
                    f = i;
                }
            }
        }

        if (f == -1) return "";

        for (int i = 0; i < arr.length; i++) {

            if (i == f) continue;
            if (arr[f] == 2) {
                if (arr[i] <= 3 && arr[i] > second) {
                    second = arr[i];
                    sec = i;
                }
            } else {
                if (arr[i] > second) {
                    second = arr[i];
                    sec = i;
                }
            }
        }

        if (sec == -1) return "";

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == f || i == sec) continue;
            list.add(i);
        }

        int i1 = list.get(0);
        int i2 = list.get(1);

        int third, fourth;

        if (arr[i1] <= 5 && arr[i2] <= 5) {
            third = Math.max(arr[i1], arr[i2]);
            fourth = Math.min(arr[i1], arr[i2]);
        } else if (arr[i1] <= 5) {
            third = arr[i1];
            fourth = arr[i2];
        } else if (arr[i2] <= 5) {
            third = arr[i2];
            fourth = arr[i1];
        } else {
            return "";
        }

        return "" + arr[f] + arr[sec] + ":" + third + fourth;
    }
}