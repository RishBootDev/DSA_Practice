import java.util.*;

public class WeightedUniformString {

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        Map<Character,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> ent: map.entrySet()){

            int temp=ent.getKey()-'a'+1;
            int sum=temp;
            int limit=ent.getValue();
            while(limit-->0){
                set.add(sum);
                sum+=temp;
            }
        }

        List<String> list=new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            if(set.contains(queries.get(i))){
                list.add("YES");
            }else list.add("NO");
        }

        return list;
    }
}
