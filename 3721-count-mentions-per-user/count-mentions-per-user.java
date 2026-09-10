class Solution {
    public int[] countMentions(int n, List<List<String>> events) {

         events.sort((l1, l2) -> {
            int time1 = Integer.parseInt(l1.get(1));
            int time2 = Integer.parseInt(l2.get(1));

            if (time1 != time2) {
                return Integer.compare(time1, time2);
            }

            if (l1.getFirst().equals("OFFLINE") &&
                    l2.getFirst().equals("MESSAGE")) {
                return -1;
            }

            if (l1.getFirst().equals("MESSAGE") &&
                    l2.getFirst().equals("OFFLINE")) {
                return 1;
            }

            return 0;
        });
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[n];

        for(List<String> event : events) {
            int timestamp = Integer.parseInt(event.get(1));
            if(event.getFirst().equals("MESSAGE")) {
                if(event.getLast().equals("ALL")){
                    for (int i = 0; i < n; i++) {
                        ans[i]++;
                    }
                }else if (event.getLast().equals("HERE")) {
                    for (int i = 0; i < n; i++) {
                        if(!map.containsKey(i) || map.containsKey(i) && map.get(i) <= timestamp) {
                            ans[i]++;
                        }
                    }
                }else {
                    String arr [] = event.getLast().split(" ");
                    for(String str : arr) {
                        int idx = Integer.parseInt(str.substring(2));
                        ans[idx]++;
                    }
                }
            }else {
                int idx = Integer.parseInt(event.getLast());
                map.put(idx, timestamp + 60);
            }
        }
        return ans;
    }
}