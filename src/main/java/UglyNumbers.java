import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumbers {


    public static void main(String[] args) {

    }

    // this solution uses the dynamic programming
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

    // alternative approach-> we use priority queue
    public static int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        pq.add(1L);
        seen.add(1L);

        long ugly = 1;

        for (int i = 0; i < n; i++) {
            ugly = pq.poll();

            long next2 = ugly * 2;
            long next3 = ugly * 3;
            long next5 = ugly * 5;

            if (seen.add(next2)) pq.add(next2);
            if (seen.add(next3)) pq.add(next3);
            if (seen.add(next5)) pq.add(next5);
        }

        return (int) ugly;
    }

}
