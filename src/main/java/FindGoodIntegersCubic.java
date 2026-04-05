import java.util.*;

public class FindGoodIntegersCubic {

    public List<Integer> findGoodIntegers(int n) {

        int limit = (int) Math.cbrt(n);

        Map<Integer, Integer> map = new HashMap<>();

        for(int a = 1; a <= limit; a++) {
            int a3 = a*a*a;

            for(int b = a ; b <= limit ; b++) {
                int sum = a3 + b*b*b;

                if(sum > n) break;

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if(ent.getValue()>=2) ans.add(ent.getKey());
        }

        Collections.sort(ans);

        return ans;
    }

}
