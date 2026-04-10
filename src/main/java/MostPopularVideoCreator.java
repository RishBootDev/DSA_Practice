import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularVideoCreator {

    public List<List<String>> mostPopularCreator(String[] creators,
                                                 String[] ids,
                                                 int[] views) {

        Map<String, Long> map = new HashMap<>();
        Map<String, Pair> track = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            String creator = creators[i];
            int view = views[i];

            map.put(creator, map.getOrDefault(creator, 0l) + view);

            if (track.containsKey(creator)) {
                Pair pair = track.get(creator);

                if (pair.view < view) {
                    track.put(creator, new Pair(id, view));
                } else if (pair.view == view) {
                    if (pair.id.compareTo(id) > 0) {
                        track.put(creator, new Pair(id, view));
                    }
                }
            } else {
                track.put(creator, new Pair(id, view));
            }
        }

        long max = Long.MIN_VALUE;
        for (long c : map.values()) max = Math.max(c, max);

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, Long> ent : map.entrySet()) {
            if (ent.getValue() == max) {
                String creator = ent.getKey();
                String id = track.get(creator).id;

                List<String> list = new ArrayList<>();
                list.add(creator);
                list.add(id);

                ans.add(list);
            }
        }

        return ans;
    }

    static class Pair {
        String id;
        int view;

        public Pair(String id, int view) {
            this.id = id;
            this.view = view;
        }
    }
}