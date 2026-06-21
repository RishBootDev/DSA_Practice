class LockingTree {

    private List<List<Integer>> pat;
    private List<List<Integer>> tree;
    private Map<Integer, Integer> lock;

    public LockingTree(int parent[]) {
        this.tree = new ArrayList<>();
        this.pat = new ArrayList<>();
        this.lock = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            tree.add(new ArrayList<>());
            pat.add(new ArrayList<>());
        }

        for (int i = 0; i < parent.length; i++) {
            int a = i;
            int b = parent[i];
            if (b != -1) {
                tree.get(b).add(a);
                pat.get(a).add(b);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (!lock.containsKey(num)) {
            lock.put(num, user);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {

        if (lock.containsKey(num) && lock.get(num) == user) {
            lock.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {

        if (lock.containsKey(num)) return false;
        if (!lockedAncestor(num)) return false;
        int count = lockedDescendent(num);
        if (count < 1) return false;
        lock.put(num, user);
        return true;
    }

    public boolean lockedAncestor(int start) {

        if (pat.get(start).isEmpty()) return true;
        int parent = pat.get(start).get(0);
        if (lock.containsKey(parent)) return false;
        return lockedAncestor(parent);
    }

    public int lockedDescendent(int start) {

        int count = 0;
        for (int node : tree.get(start)) {
            if (lock.containsKey(node)) {
                count++;
                lock.remove(node);
            }
            count += lockedDescendent(node);
        }
        return count;
    }
}