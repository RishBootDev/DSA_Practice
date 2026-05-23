class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int ans [] = new int[prices.length];
        int j = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            
            int temp = prices[i];

            while(!stack.isEmpty() && stack.peek() > temp) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = prices[i];
            }
            else {
                ans[i] = prices[i] - stack.peek();
            }

            stack.push(prices[i]);

        }

        return ans;
        
    }
}