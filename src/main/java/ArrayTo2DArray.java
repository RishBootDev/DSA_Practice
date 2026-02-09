import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArrayTo2DArray {

    public List<List<Integer>> findMatrix(int[] nums) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int temp = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while(temp < nums.length){

            List<Integer> list = new ArrayList<>();

            for(Map.Entry<Integer, Integer> ent: map.entrySet()){

                int key = ent.getKey();
                int value = ent.getValue();

                if(value > 0){
                    list.add(key);
                    map.put(key, value-1);
                    temp++;
                }
            }

            ans.add(list);

        }

        return ans;

    }

}
