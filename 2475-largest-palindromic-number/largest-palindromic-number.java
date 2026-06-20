class Solution {
    public String largestPalindromic(String num) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : num.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        List<Integer>duo = new ArrayList<>();
        List<Integer>single = new ArrayList<>();
        for(char ch : map.keySet()){
            for(int i=0;i<map.get(ch)/2;i++){
                duo.add(ch-'0');
            }

            if(map.get(ch)%2!=0){
                single.add(ch-'0');
            }
            
        }

        Collections.sort(duo, Collections.reverseOrder());
        Collections.sort(single, Collections.reverseOrder());


        while(duo.size()>0 && duo.get(0)==0){
            duo.remove(0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : duo){
            sb.append(i);
        }
        
        StringBuilder sb2 = new StringBuilder(sb).reverse();

        if(single.size()!=0){
            sb.append(single.get(0));
        }
        sb.append(sb2);
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();
        
    }
}