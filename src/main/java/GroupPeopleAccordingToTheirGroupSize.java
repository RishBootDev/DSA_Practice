import java.util.ArrayList;
import java.util.List;

public class GroupPeopleAccordingToTheirGroupSize {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            Pair pair = new Pair(i, groupSizes[i]);
            list.add(pair);
        }
        list.sort((p1, p2) -> p1.grp - p2.grp);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < list.size();) {
            List<Integer> grp = new ArrayList<>();
            Pair pair = list.get(i);
            int temp = pair.grp;
            while(temp -->0) {
                grp.add(list.get(i).idx);
                i++;
            }
            ans.add(grp);
        }
        return ans;
    }

    static class Pair{
        int idx;
        int grp;

        public Pair(int idx, int grp) {
            this.idx = idx;
            this.grp = grp;
        }
    }
}
