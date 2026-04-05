import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignUndergroundSystem {

    private Map<Integer, Stations> map;
    private Map<String, List<Integer>> time;

    public DesignUndergroundSystem() {
        this.map = new HashMap<>();
        this.time = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
         map.put(id, new Stations(stationName, null, t, null));
    }

    public void checkOut(int id, String stationName, int t) {

         Stations st = map.get(id);
         st.out = stationName;
         st.outTime = t;

         String temp = st.in +" " + st.out;
         List<Integer> list = time.getOrDefault(temp, new ArrayList<>());
         list.add(st.outTime - st.inTime);
         time.put(temp, list);
         map.put(id, st);

        System.out.println(map);
    }

    public double getAverageTime(String startStation, String endStation) {

        String key = startStation + " " + endStation;
        List<Integer> list = time.get(key);

        double ans = 0;
        for(int x : list) ans += x;

        return ans/list.size();
    }

    static class Stations{
         String in;
         String out;

         Integer inTime;
         Integer outTime;

        public Stations(String in, String out, Integer inTime, Integer outTime) {
            this.in = in;
            this.out = out;
            this.inTime = inTime;
            this.outTime = outTime;
        }

        @Override
        public String toString() {
            return "Stations{" +
                    "in='" + in + '\'' +
                    ", out='" + out + '\'' +
                    '}';
        }
    }
}
