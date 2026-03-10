import java.util.ArrayList;
import java.util.List;

public class PlantsRemovalPesticide {

        public static int poisonousPlants(List<Integer> p) {

            int count = 0;
            while (true) {
                List<Integer> list = new ArrayList<>();

                for (int i = 1; i < p.size(); i++) {

                    if (p.get(i - 1) > p.get(i)) list.add(p.get(i - 1));
                }

                p = list;
                if(checkSorted(list)) return count;

                count++;
            }
        }

        public static boolean checkSorted(List<Integer> list) {

            for (int i = 0; i < list.size()-1; i++) {
                if(list.get(i) < list.get(i+1)) return false;
            }
            return true;
        }
}
