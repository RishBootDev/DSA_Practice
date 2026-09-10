class Solution {
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int val = map.get(list2[i]);
                int sum = val + i;
                min = Math.min(min, sum);
            }
        }
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int val = map.get(list2[i]);
                int sum = val + i;
                if(min == sum) ans.add(list2[i]);
            }
        }
        String [] temp = new String[ans.size()];
        for (int i = 0; i < temp.length;i++) {
            temp[i] = ans.get(i);
        }
        return temp;
    }
}