import java.util.PriorityQueue;

public class SortIntegersByPowerValue {

    public int getKth(int lo, int hi, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int pow1 = power(a);
            int pow2 = power(b);

            if(pow2 == pow1) return a-b;
            else return pow1-pow2;
        });

        for (int i = lo; i <= hi ; i++) {
            pq.add(i);
        }

        int ans =0;
        while(k-->0 && !pq.isEmpty()){
            ans = pq.poll();
        }
        return ans;
    }

    public int power(int num) {
        if(num == 1) return 1;

        if(num % 2 == 0) return 1+power(num/2);
        return 1 + power(num * 3 + 1);
    }
}
