class Solution {

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();

        long day = 0;

        for (int i = 0; i < tasks.length; i++) {
            day++;

            if (map.containsKey(tasks[i])) {
                long val = map.get(tasks[i]);

                if (day <= val + space) {
                    day = val + space + 1;
                }
            }

            map.put(tasks[i], day);
        }

        return day;
    }
}