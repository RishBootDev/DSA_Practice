class MapSum {

    private Map<String , Integer> map;
    public MapSum() {
          map = new HashMap<>();
    }

    public void insert(String key, int val) {
       
      map.put(key, val);
    }

    public int sum(String prefix) {

        int sum = 0;
        for (Map.Entry<String, Integer> ent : map.entrySet()) {
            String key = ent.getKey();

            if (key.startsWith(prefix)) {
                sum += ent.getValue();
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */