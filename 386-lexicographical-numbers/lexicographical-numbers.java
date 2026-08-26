class Solution {
    
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list);
        List<Integer> ans = new ArrayList<>();
        for (String c : list) {
            ans.add(Integer.parseInt(c));
        }
        return ans;
    }
}