import java.util.*;

public class UniQueIntegeres {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        Collection<Integer> values=map.values();
        List<Integer> list= new ArrayList<>(List.copyOf(values));
        Collections.sort(list);

        int i=0;
        while(k>0 && i<arr.length){
            k-=arr[i];

            if(k>0){
                i++;
            }else{
                break;
            }
        }

        System.out.println(i);

        return 5;

    }
}

