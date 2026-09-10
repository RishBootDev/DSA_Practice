class Solution {
    
     public List<String> removeSubfolders(String[] folder) {

        Arrays.sort(folder);
        Set<String> set = new HashSet<>();
        for(String str : folder) {

            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '/') {
                    if(set.contains(sb.toString())) {
                        flag = false;
                        break;
                    }
                }
                    sb.append(str.charAt(i));
                
            }
            if(flag) {
                set.add(sb.toString());
            }
        }
        return new ArrayList<>(set);
    }
}