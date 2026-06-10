class Solution {
    int[] parent;
    int[] rank;

    public int find(int i) {
        if(parent[i] == i) return i;

        return parent[i] = find(parent[i]);
    }

    public void union(int a, int b) {
        int repa = find(a), repb = find(b);
        if(repa == repb) return;

        if(rank[repa] > rank[repb]) {
            parent[repb] = repa;
        } else if(rank[repa] < rank[repb]) {
            parent[repa] = repb;
        } else {
            parent[repb] = repa;
            rank[repa] ++;
        }
    }

    public int numberOfComponents(int[][] arr, int k) {
        // intesection + DSU
        int n = arr.length, m = arr[0].length;
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        rank = new int[n];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int val : arr[i]) {
                map.computeIfAbsent(i, w -> new HashSet<>()).add(val);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(intersect(map, i, j) >= k) {
                    union(i, j);
                }
            }
        }

        Set<Integer> comp = new HashSet<>();
        for(int val : parent) {
            comp.add(find(val));
        }

        return comp.size();


    }

    public int intersect(Map<Integer, Set<Integer>> map, int i, int j) {
        int count = 0;
        for(int val : map.get(i)) {
            if(map.get(j).contains(val)) count++;
        }

        return count;
    }
}