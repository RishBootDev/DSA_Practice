import java.util.HashMap;
import java.util.Stack;

public class FloodAaya {

    public int[] avoidFlood(int[] rains) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        int res[] = new int[rains.length];

        for (int c : rains){
            map.put(c,false);
        }

        int temp = -1;
        for (int i = 0; i < rains.length; i++) {

            if(rains[i] == 0) {
                temp = i;
                break;
            }
        }

        for (int i = rains.length -1; i >= temp ; i--) {
            stack.push(rains[i]);
        }

        for (int i = 0; i < rains.length; i++) {

            if(rains[i] != 0 && !map.get(rains[i])) {
                map.put(rains[i], true);
                res[i] = -1;
            }else if (rains[i] !=0 && map.get(rains[i])) {
                return new int[]{};
            }
            else {
                int j;
                for (j = i+1; j < rains.length ; j++) {
                   if(map.get(rains[i])) {
                       map.put(rains[i], false);
                       break;
                   }
                }
                res[i] = rains[j];
            }
        }

        return rains;
    }
}
