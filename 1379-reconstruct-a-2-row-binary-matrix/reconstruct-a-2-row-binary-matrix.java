class Solution {
    
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int i = 0; i < colsum.length; i++) {

            if(colsum[i] == 0) {
                ans.getFirst().add(0);
                ans.getLast().add(0);
            }else if (colsum[i] == 2 && upper != 0 && lower != 0) {
                ans.getFirst().add(1);
                ans.getLast().add(1);
                upper --;
                lower --;
            }else if(colsum[i] == 1) {
                if(upper >= lower && upper != 0) {
                    ans.getFirst().add(1);
                    ans.getLast().add(0);
                    upper--;
                }else if(lower != 0) {
                    ans.getLast().add(1);
                    ans.getFirst().add(0);
                    lower--;
                }else return new ArrayList<>();
            }else {
                return new ArrayList<>();
            }
        }

        if(upper != 0 || lower!= 0) return new ArrayList<>();
        
        return ans;
    }
}