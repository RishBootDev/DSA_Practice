import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovingStonesUntilConsecutive {

    public int[] numMovesStones(int a, int b, int c) {
        List<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        int ans[] = new int[2];

        Collections.sort(temp);
        if(temp.getFirst() == temp.get(1) - 1 && temp.getLast() == temp.get(1)+1){
            ans[0] = 0;
            ans[1] = 0;
        }else if(temp.getFirst() == temp.get(1) - 1 || temp.getLast() == temp.get(1)+1) {
            ans[0] = 1;
            ans[1] = Math.max(temp.get(1)- temp.getFirst(), temp.getLast() - temp.get(1));
        }else {
            ans[0] = 2;
            ans[1]= temp.get(1) - temp.getFirst() + temp.getLast() - temp.get(1);
        }
        return ans;
    }
}
