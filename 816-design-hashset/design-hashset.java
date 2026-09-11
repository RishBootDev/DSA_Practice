class MyHashSet {

    List<Integer> set;
    public MyHashSet() {
        this.set = new ArrayList<>();
    }

    public void add(int key) {
        if(contains(key)) return;
        this.set.add(key);
    }

    public void remove(int key) {
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(key)) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        for(int c : set) {
            if(c == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */