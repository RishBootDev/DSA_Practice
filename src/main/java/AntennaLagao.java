import java.util.*;

public class AntennaLagao {

    public static int hackerlandRadioTransmitters(List<Integer> arr, int k) {

        Collections.sort(arr);

        Set<Integer> set = new HashSet<>(arr);

        int m=0;
        int count=0;
        for (int i = 1; i <= arr.getLast();) {

            if(set.contains(i)){
                count++;

                int temp=i+k;
                while(!set.contains(temp)){
                    temp--;
                }
                i=temp+k+1;
            }else{
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,4,6);
        System.out.println(hackerlandRadioTransmitters(list,1));
    }
}
