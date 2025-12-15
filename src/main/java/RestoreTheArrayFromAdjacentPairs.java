import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {

    public static void main(String[] args) {
        int[][] adjacentPairs3 = {
                {7, 9},
                {1, 3},
                {5, 7},
                {3, 5}
        };
        restoreArray(adjacentPairs3);
    }

    public static ArrayList<Integer>  restoreArray(int[][] adjacentPairs) {

        Map<Integer, Boolean> track = new HashMap<>();
        Map<Integer, List<Integer>> pairs = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; i++) {

            if (pairs.containsKey(adjacentPairs[i][0])) {
                pairs.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(adjacentPairs[i][1]);
                pairs.put(adjacentPairs[i][0], list);
            }
            if (pairs.containsKey(adjacentPairs[i][1])) {
                pairs.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(adjacentPairs[i][0]);
                pairs.put(adjacentPairs[i][1], list);
            }
        }

        int start=-1;
        for(Map.Entry<Integer,List<Integer>> ent: pairs.entrySet()){
            if(ent.getValue().size()==1){
                start=ent.getKey();
                break;
            }
        }

        for(Map.Entry<Integer,List<Integer>> ent: pairs.entrySet()){
           track.put(ent.getKey(),false);
        }

        int n=pairs.size();
        ArrayList<Integer> arr=new ArrayList<>();
        while(n-->0){
            arr.add(start);
            track.put(start,true);
            List<Integer> list=pairs.get(start);
            if(list.size()==1){
                start=list.getFirst();
            }else{
                if(!track.get(list.getFirst())){
                    start=list.getFirst();
                }else start=list.getLast();
            }
        }

        System.out.println(arr);
        System.out.println(pairs);
        return arr;
    }
}
