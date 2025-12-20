import java.util.*;

public class SherlockAndString {
    public static void main(String[] args) {

    }
    public static String isValid(String s) {


        Map<Character,Integer> map=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        List<Integer> list=new ArrayList<>(map.values());
        Set<Integer> set=new HashSet<>();

        for (int i = 0; i <list.size(); i++) {
            set.add(list.get(i));
        }
        if(set.size()>2) return "No";
        Collections.sort(list);

        if(list.size()<2) return "No";

        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)!=list.get(i+1)){
                if(list.get(i+1)-list.get(i)>1) return "No";
            }
        }

        Map<Integer,Integer> temp=new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            temp.put(list.get(i),temp.getOrDefault(list.get(i),0)+1);
        }

        List<Integer> res=new ArrayList<>(temp.values());
        Collections.sort(res);
        if(res.get(0)!=1) return "NO";


        return "Yes";

    }
}
