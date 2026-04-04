import java.util.ArrayList;
import java.util.List;

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        List<Integer> ans = new ArrayList<>();

        for(int x : grades) {
            if(x < 38) ans.add(x);
            else if (x >= 38 && x <= 40) ans.add(40);
            else {
                int rem = x % 5;
                int d = 5 - rem;
                if(d < 3) ans.add(x + d);
                else ans.add(x);

            }

        }
        return ans;
    }
}
