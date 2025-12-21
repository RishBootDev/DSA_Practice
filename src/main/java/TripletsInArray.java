import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletsInArray {

    public static int beautifulTriplets(int d, List<Integer> arr) {

        Set<Integer> set=new HashSet<>();

        for (int c: arr) {
            set.add(c);
        }

        int count=0;
        for (int i = 0; i < arr.size()-2; i++) {
            int first=arr.get(i);

            if(set.contains(first+d) && set.contains(first+2*d))count++;

        }

        return count;

    }

}
