class Solution {
    
    public List<Long> maximumEvenSplit(long finalSum) {

        if(finalSum % 2 == 1) return new ArrayList<>();
        List<Long> ans = new ArrayList<>();

        long temp = 2;
        long sum = 0;

        while(sum + temp <= finalSum) {
            ans.add(temp);
            sum += temp;
            temp += 2;
        }

        if(sum == finalSum) return ans;
        temp = finalSum - sum;
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + temp);

        return ans;
    }
}