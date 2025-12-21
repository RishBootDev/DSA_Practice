import java.util.*;

public class MinimumDeletionCostToMaksAllElementsEqual {

        public long minCost(String s, int[] cost) {

            Map<Character,Long> map=new HashMap<>();

            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    long value=map.get(s.charAt(i));
                    value+=cost[i];
                    map.put(s.charAt(i),value);
                }else map.put(s.charAt(i),(long)cost[i]);
            }

            List<Long> list=new ArrayList<>(map.values());

            Collections.sort(list);

            long ans=0;
            for(int i=0;i<list.size()-1;i++){
                ans+=list.get(i);
            }

            return ans;
        }
    }
