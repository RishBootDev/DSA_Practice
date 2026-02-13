import java.util.HashSet;
import java.util.Set;

public class UglyNumbers {


    public static void main(String[] args) {

    }
    public static int nthUglyNumbers(int n) {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        int i = 2;
        int ans = 1;

        while(set.size() < n){
            if(i%2 == 0 && set.contains(i/2)) {
                set.add(i);
                ans = i;
            }
            else if(i%3 == 0 && set.contains(i/3)){
                set.add(i);
                ans = i;
            }
            else if(i%5 == 0 && set.contains(i/5)){
                set.add(i);
                ans = i;
            }

            i++;
        }

        return ans;
    }

}
