import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoArraysFactor {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Set<Integer> set=getTotalFactorsOf(b);
        Collections.sort(a);

        int count=0;

        for(int c: set){

            for (int x: a) {
                 if(c%x!=0) continue;
            }
            count++;
        }

        return count;


    }

    public static Set<Integer> getTotalFactorsOf(List<Integer> arr){

        Set<Integer> ans=new HashSet<>();
        Collections.sort(arr);

        outer:
        for (int i = 1; i <arr.getFirst() ; i++) {

            for (int c:arr) {
                if(c%i!=0) continue outer;
            }
            ans.add(i);

        }

        return ans;
    }
    
    public static int lcm(List<Integer> list){

        int temp=list.getFirst();
        for (int i = 1; i < list.size()-1; i++) {
            int a=temp;
            int b=list.get(i+1);

            for (int j = b;; j++) {
                if(b%j==0 && a%j==0) {
                        temp=j;
                        break;
                }
            }
        }
        return temp;
    }

}
