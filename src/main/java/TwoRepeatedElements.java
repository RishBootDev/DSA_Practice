import java.util.HashSet;

public class TwoRepeatedElements {

    public int[] twoRepeated(int[] nums) {
        int[] arr = new int[2];
        int j = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                arr[j++] = num;
            } else {
                set.add(num);
            }
        }

        return arr;

    }
}
