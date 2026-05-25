import java.util.List;

public class MaximumDistanceInArray {


    // this passed 122 test cases out of 136 test cases
    public int maxDistance(List<List<Integer>> arrays) {

        arrays.sort((l1, l2)->
                l1.getFirst() - l2.getFirst());

        int min = arrays.getFirst().getFirst();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); i++) {
            max = Math.max(max, arrays.get(i).getLast());
        }

        return Math.abs(max - min);
    }
}
