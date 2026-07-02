class TaskManager {

    PriorityQueue<Task> pq;
    Map<Integer, Task> map;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority;
            }
            return b.taskId - a.taskId;
        });

        map = new HashMap<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        map.put(taskId, task);
        pq.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = map.get(taskId);
        Task updated = new Task(old.userId, taskId, newPriority);

        map.put(taskId, updated);
        pq.add(updated);
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();

            if (map.containsKey(top.taskId) && map.get(top.taskId) == top) {
                map.remove(top.taskId);
                return top.userId;
            }
        }

        return -1;
    }

    static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */