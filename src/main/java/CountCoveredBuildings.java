import java.util.*;

public class CountCoveredBuildings {

    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, List<Integer>> mapx = new HashMap<>();
        Map<Integer, List<Integer>> mapy = new HashMap<>();

        for(int [] building : buildings) {
            int x = building[0];
            int y = building[1];

            if(mapx.containsKey(x)) {
                List<Integer> list = mapx.get(x);
                list.add(y);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                mapx.put(x, list);
            }

            if(mapy.containsKey(y)) {
                List<Integer> list = mapx.get(y);
                list.add(x);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                mapy.put(y, list);
            }
        }

        int count = 0;
        for(List<Integer> list : mapx.values())
            Collections.sort(list);

        for(List<Integer> list : mapy.values())
            Collections.sort(list);


        for(int[] build : buildings) {

            int x = build[0];
            int y = build[1];

            List<Integer> sameX = mapx.get(x);
            List<Integer> sameY = mapy.get(y);

            if (y != sameX.getFirst()&&y != sameX.getLast() && x != sameY.getFirst() && x != sameY.getLast()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String temp = String.valueOf(-234);
        System.out.println(temp.charAt(0));
    }
}
