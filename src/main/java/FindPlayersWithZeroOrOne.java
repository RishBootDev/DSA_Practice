import java.util.*;

public class FindPlayersWithZeroOrOne {


    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> lose = new HashMap<>();
        Map<Integer,Integer> win = new HashMap<>();

        for(int [] match: matches){

            lose.put(match[1], lose.getOrDefault(match[1],0)+1);
            win.put(match[0], win.getOrDefault(match[0],0)+1);

        }

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        for(Map.Entry<Integer,Integer> ent: lose.entrySet()){
            if(ent.getValue() ==1) temp.add(ent.getKey());
        }

        ans.add(temp);
        Collections.sort(temp);
        temp = new ArrayList<>();

        for (Map.Entry<Integer,Integer> ent : win.entrySet()){

            if(!lose.containsKey(ent.getKey())){
                temp.add(ent.getKey());
            }
        }

        Collections.sort(temp);
        ans.add(temp);

        return ans;

    }
}
