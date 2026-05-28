import java.util.*;

class Solution {
    
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, List<Integer>> mapx = new HashMap<>();
        Map<Integer, List<Integer>> mapy = new HashMap<>();

        for(int [] building : buildings) {
            int x = building[0];
            int y = building[1];

            if(mapx.containsKey(x)) {
                mapx.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                mapx.put(x, list);
            }

            if(mapy.containsKey(y)) {
                mapy.get(y).add(x);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                mapy.put(y, list);
            }
        }

        for(List<Integer> list : mapx.values())
            Collections.sort(list);

        for(List<Integer> list : mapy.values())
            Collections.sort(list);

        int count = 0;
        for(int[] build : buildings) {
            int x = build[0];
            int y = build[1];

            List<Integer> sameX = mapx.get(x);
            List<Integer> sameY = mapy.get(y);

            if (y > sameX.get(0) && y < sameX.get(sameX.size() - 1) && 
                x > sameY.get(0) && x < sameY.get(sameY.size() - 1)) {
                count++;
            }
        }

        return count;
    }
}