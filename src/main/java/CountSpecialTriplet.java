import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSpecialTriplet {
    public static void main(String[] args) {

    }

    public static int specialTriplets(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[nums.length];

        int barr[]=new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i]*2)){
                arr[i]=map.get(nums[i]*2);
            }

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        map=new HashMap<>();

        for (int i = nums.length-1; i >=0; i--) {

            if(map.containsKey(nums[i]*2)){
                barr[i]=map.get(nums[i]*2);
            }

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            ans+=arr[i]*barr[i];
        }

        return ans;


    }


}
