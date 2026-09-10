class Solution {
    
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int k = i;
            if((k + 10) <= s.length()) {
                for (int j = 0; j < 10; j++) {
                    sb.append(s.charAt(k++));
                }
                 map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        
           
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> ent : map.entrySet()) {
            if(ent.getValue() > 1) {
                ans.add(ent.getKey());
            }
        }
        System.out.println(map);
        return ans;
    }
}