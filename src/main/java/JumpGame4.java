import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGame4 {

    // this is the backtracking approach but it got me TLE
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(arr[i], temp);
            }
        }
        boolean visited[] = new boolean[arr.length];
        return helper(arr, 0, map, visited);
    }

    public int helper(int arr[], int i, Map<Integer, List<Integer>> map, boolean visited[]) {

        if(i < 0 || i >= arr.length) {
            return Integer.MAX_VALUE;
        }
        if(i == arr.length - 1) {
            return 0;
        }
        if(visited[i]) {
            return Integer.MAX_VALUE;
        }

        visited[i] = true;
        int first = helper(arr, i + 1, map, visited);
        if(first != Integer.MAX_VALUE) {
            first++;
        }
        int second = helper(arr, i - 1, map, visited);
        if(second != Integer.MAX_VALUE) {
            second++;
        }
        int third = Integer.MAX_VALUE;

        for(int c : map.get(arr[i])) {
            if(c != i) {
                int temp = helper(arr, c, map, visited);
                if(temp != Integer.MAX_VALUE) {
                    third = Math.min(third, temp + 1);
                }
            }
        }
        visited[i] = false;
        return Math.min(first, Math.min(second, third));
    }
}
